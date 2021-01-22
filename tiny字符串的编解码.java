
public class Codec {

    // 散列表原路返回即可
    Map<String,String> map=new HashMap();

    String PREFIX="http://tinyurl.com";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put(String.valueOf(longUrl.hashCode()),longUrl);
        return PREFIX+longUrl.hashCode();    
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace(PREFIX,""));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));