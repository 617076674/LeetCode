package question1410_html_entity_parser;

public class Solution {
    public String entityParser(String text) {
        return text.replaceAll("&quot;", "\"").replaceAll("&apos;", "'")
                .replaceAll("&amp;", "&").replaceAll("&gt;", ">")
                .replaceAll("&lt;", "<").replaceAll("&frasl;", "/");
    }
}