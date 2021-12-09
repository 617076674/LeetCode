package question1912;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

public class MovieRentingSystem {

  private static class Movie {

    int shopId;

    int movieId;

    int price;

    public Movie(int shopId, int movieId, int price) {
      this.shopId = shopId;
      this.movieId = movieId;
      this.price = price;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Movie movie = (Movie) o;
      return shopId == movie.shopId &&
          movieId == movie.movieId;
    }

    @Override
    public int hashCode() {
      return Objects.hash(shopId, movieId);
    }
  }

  private Map<Integer, PriorityQueue<Movie>> movieId2remainedPQ = new HashMap<>();


  private PriorityQueue<Movie> borrowedPQ = new PriorityQueue<>((movie1, movie2) -> {
    if (movie1.price == movie2.price) {
      if (movie1.shopId == movie2.shopId) {
        return movie1.movieId - movie2.movieId;
      }
      return movie1.shopId - movie2.shopId;
    }
    return movie1.price - movie2.price;
  });

  private Map<Long, Movie> key2Movie = new HashMap<>();

  private Set<Long> borrowedKeySet = new HashSet<>();

  private Set<Long> inBorrowedPQSet = new HashSet<>(), inRemainedPQSet = new HashSet<>();

  private static Long getKey(int movieId, int shopId) {
    return movieId * 1000000L + shopId;
  }

  public MovieRentingSystem(int n, int[][] entries) {
    for (int[] entry : entries) {
      int shopId = entry[0], movieId = entry[1], price = entry[2];
      Movie movie = new Movie(shopId, movieId, price);
      PriorityQueue<Movie> pq = movieId2remainedPQ.get(movieId);
      if (null == pq) {
        pq = new PriorityQueue<>((movie1, movie2) -> {
          if (movie1.price == movie2.price) {
            return movie1.shopId - movie2.shopId;
          }
          return movie1.price - movie2.price;
        });
        pq.add(movie);
        movieId2remainedPQ.put(movieId, pq);
      } else {
        pq.add(movie);
      }
      long key = getKey(movieId, shopId);
      inRemainedPQSet.add(key);
      key2Movie.put(key, movie);
    }
  }

  public List<Integer> search(int movie) {
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Movie> pq = movieId2remainedPQ.get(movie);
    List<Movie> temp = new ArrayList<>();
    while (null != pq && !pq.isEmpty() && result.size() < 5) {
      Movie cur = pq.poll();
      long key = getKey(cur.movieId, cur.shopId);
      if (!borrowedKeySet.contains(key)) {
          temp.add(cur);
          result.add(cur.shopId);
      } else {
          inRemainedPQSet.remove(key);
      }
    }
    for (Movie cur : temp) {
      pq.add(cur);
    }
    return result;
  }

  public void rent(int shop, int movie) {
    Long key = getKey(movie, shop);
    Movie borrowed = key2Movie.get(key);
    borrowedKeySet.add(key);
    if (inBorrowedPQSet.add(key)) {
        borrowedPQ.add(borrowed);
    }
  }

  public void drop(int shop, int movie) {
    Long key = getKey(movie, shop);
    Movie returned = key2Movie.get(key);
    borrowedKeySet.remove(key);
    if (inRemainedPQSet.add(key)) {
        movieId2remainedPQ.get(movie).add(returned);
    }
  }

  public List<List<Integer>> report() {
    List<List<Integer>> result = new ArrayList<>();
    List<Movie> temp = new ArrayList<>();
    while (!borrowedPQ.isEmpty() && result.size() < 5) {
      Movie cur = borrowedPQ.poll();
      long key = getKey(cur.movieId, cur.shopId);
      if (borrowedKeySet.contains(key)) {
          temp.add(cur);
          List<Integer> list = new ArrayList<>();
          list.add(cur.shopId);
          list.add(cur.movieId);
          result.add(list);
      } else {
          inBorrowedPQSet.remove(key);
      }
    }
    for (Movie movie : temp) {
      borrowedPQ.add(movie);
    }
    return result;
  }

}