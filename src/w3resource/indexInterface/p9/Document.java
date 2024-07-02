package w3resource.indexInterface.p9;

public class Document implements Searchable{
    private String content;
    @Override
    public boolean search(String keyword) {
      return false;
    }
}
