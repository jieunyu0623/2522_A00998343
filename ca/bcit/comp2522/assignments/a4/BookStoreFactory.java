package ca.bcit.comp2522.assignments.a4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * recreate bookstore.xml file.
 *
 * @author Jieun Yu
 * @version 2020
 */
public final class BookStoreFactory {

  /**
   * Document.
   */
  private final Document bookDocument;

  /**
   * BookStoreFactory object.
   */
  private static BookStoreFactory instance = null;

  private BookStoreFactory() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    bookDocument = builder.newDocument();
  }

  /**
   * singleton constructor.
   * @return instance
   * @throws ParserConfigurationException ParserConfigurationException
   */
  public static BookStoreFactory getInstance()
          throws ParserConfigurationException {
    if (instance == null) {
      instance = new BookStoreFactory();
      return instance;
    }
    return instance;
  }

  private Document getDOM(final String fileName)
          throws ParserConfigurationException, IOException, SAXException {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    String directory = "/Users/jieun/IdeaProjects/2522_A00998343/"
            + "src/ca/bcit/comp2522/assignments/a4/" + fileName;
    File file = new File(directory);

    return builder.parse(file);
  }

  private Node createBook(final Book books) {

    Element book = bookDocument.createElement("book");
    book.setAttribute("isbn", books.getIsbn());
    book.setAttribute("year", books.getYear());
    book.setAttribute("edition", books.getEdition());

    Element names = bookDocument.createElement("name");
    book.appendChild(names);
    names.insertBefore(bookDocument.createTextNode(books.getBookName()),
            names.getLastChild());

    Element description = bookDocument.createElement("description");
    book.appendChild(description);
    description.insertBefore(bookDocument.createTextNode(
            books.getDescription()), description.getLastChild());

    Element courseapplicability = bookDocument.createElement(
            "courseapplicability");
    book.appendChild(courseapplicability);

    for (String course: books.getCourses()) {
      Element courses = bookDocument.createElement("course");
      courses.setAttribute("institute", "BCIT");
      courses.insertBefore(bookDocument.createTextNode(course),
              courses.getLastChild());
      courseapplicability.appendChild(courses);
    }
    for (String author: books.getAuthors()) {
      Element authors = bookDocument.createElement("author");
      String[] arr = author.split(" ");
      authors.setAttribute("firstname", arr[0]);
      authors.setAttribute("lastname", arr[1]);
      book.appendChild(authors);
    }

    Element publisher = bookDocument.createElement("publisher");
    publisher.insertBefore(bookDocument.createTextNode(
            books.getPublisher()), publisher.getLastChild());
    book.appendChild(publisher);

    for (String price: books.getPrice()) {
        Element prices = bookDocument.createElement("price");
        String[] arr = price.split(" ");
        prices.setAttribute("currency", arr[0]);
        prices.insertBefore(bookDocument.createTextNode(arr[1]),
                prices.getLastChild());
        book.appendChild(prices);
    }

    Element stock = bookDocument.createElement("stock");
    book.appendChild(stock);

    Element category = bookDocument.createElement("category");
    category.insertBefore(bookDocument.createTextNode(
            books.getStock().getCategory()), category.getLastChild());
    stock.appendChild(category);

    if (books.getStock().getSubCategory() != null) {
      Element subCategory = bookDocument.createElement("subcategory");
      subCategory.insertBefore(bookDocument.createTextNode(
              books.getStock().getSubCategory()), subCategory.getLastChild());
      stock.appendChild(subCategory);
    }

    Element copiesinstock = bookDocument.createElement("copiesinstock");
    copiesinstock.insertBefore(bookDocument.createTextNode(
            books.getStock().getCopiesInStock()), copiesinstock.getLastChild());
    stock.appendChild(copiesinstock);

    Element coverimage = bookDocument.createElement("coverimage");
    coverimage.setAttribute("url", books.getStock().getCoverImage());
    stock.appendChild(coverimage);

    Element availability = bookDocument.createElement("availability");
    availability.setAttribute("days", books.getStock().getAvailability());
    stock.appendChild(availability);

    return book;
  }

  private Document assembleBookstore() {

    ArrayList<String> authors1 = new ArrayList<>();
    ArrayList<String> courses1 = new ArrayList<>();
    ArrayList<String> price1 = new ArrayList<>();

    authors1.add("Carole Wade");
    authors1.add("Carol Tavris");
    courses1.add("PSYC1101");
    price1.add("CAN 110.00");

    Stock stock1 = new Stock("Psychology", null,
            10, "./images/psychology-cover.jpg", 1);

    Book book1 = new Book("Psychology",
            "Introductory level Pyschology course book",
            courses1, authors1, "Prentice Hall", price1, stock1,
            "0321049314", 2000, 6);

    ArrayList<String> authors2 = new ArrayList<>();
    ArrayList<String> courses2 = new ArrayList<>();
    ArrayList<String> price2 = new ArrayList<>();

    authors2.add("Eric Burke");
    courses2.add("MMSD4670");
    price2.add("CAN 59.95");
    price2.add("US 39.95");

    Stock stock2 = new Stock("Programming", "Java Programming",
            2, "./images/java-and-xslt-cover.jpg", 2);
    Book book2 = new Book("Java and XSLT",
            "Embedding XML Processing Into Java Applications",
            courses2, authors2, "O&Reilly", price2, stock2,
            "0596001436", 2001, 1);

    ArrayList<String> authors3 = new ArrayList<>();
    ArrayList<String> courses3 = new ArrayList<>();
    ArrayList<String> price3 = new ArrayList<>();

    authors3.add("Priscilla Walmsley");
    courses3.add("MMSD4670");
    courses3.add("MMSD0410");
    courses3.add("MMSD4620");
    price3.add("US 31.49");

    Stock stock3 = new Stock("Technology", "XML Schema",
            2, "./images/xml-schema-cover-.jpg", 4);
    Book book3 = new Book("Definitive XML Schema",
            "XML Schema Reference and Tutorial",
            courses3, authors3, "Prentice Hall", price3, stock3,
            "0130655678", 2001, 1);

    Node bookStore = bookDocument.createElement("bookstore");
    bookStore.appendChild(createBook(book1));
    bookStore.appendChild(createBook(book2));
    bookStore.appendChild(createBook(book3));
    bookDocument.appendChild(bookStore);

    return bookDocument;

  }

  private void outputBookstore(final String fileName) throws Exception {

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(assembleBookstore());
    String directory = "/Users/jieun/IdeaProjects/"
            + "2522_A00998343/src/ca/bcit/comp2522/assignments/a4/" + fileName;
    StreamResult result = new StreamResult(directory);
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

    transformer.transform(source, result);

  }

  /**
   * creates bookstore-copy.xml.
   * @param originalDoc the bookstore.xml file
   * @param newDoc the bookstore-copy.xml file
   * @throws Exception exception
   */
  public void duplicateBookstore(final String originalDoc, final String newDoc)
          throws Exception {

    getDOM(originalDoc);
    outputBookstore(newDoc);

  }

  private static final class Book {

    /**
     * book Name.
     */
    private final String bookName;

    /**
     * description.
     */
    private final String description;

    /**
     * courses.
     */
    private final ArrayList<String> courses;

    /**
     * authors.
     */
    private final ArrayList<String> authors;

    /**
     * publisher.
     */
    private final String publisher;

    /**
     * price.
     */
    private final ArrayList<String> price;

    /**
     * stocks.
     */
    private final Stock stocks;

    /**
     * isbn.
     */
    private final String isbn;

    /**
     * year.
     */
    private final String year;

    /**
     * edition.
     */
    private final String edition;

    private Book(final String name, final String descrip,
                 final ArrayList<String> course,
                final ArrayList<String> author, final String pub,
                 final ArrayList<String> pr, final Stock stock,
                 final String isbnNum, final int years, final int editions) {
      bookName = name;
      description = descrip;
      courses = new ArrayList<>();
      courses.addAll(course);
      authors = new ArrayList<>();
      authors.addAll(author);
      publisher = pub;
      price = new ArrayList<>();
      price.addAll(pr);
      stocks = stock;
      isbn = isbnNum;
      year = years + "";
      edition = editions + "";
    }

    public String getBookName() {
      return bookName;
    }

    public String getDescription() {
      return description;
    }

    public ArrayList<String> getCourses() {
      return courses;
    }

    public ArrayList<String> getAuthors() {
      return authors;
    }

    public String getPublisher() {
      return publisher;
    }

    public ArrayList<String> getPrice() {
      return price;
    }

    public Stock getStock() {
      return stocks;
    }

    public String getIsbn() {
      return isbn;
    }

    public String getYear() {
      return year;
    }

    public String getEdition() {
      return edition;
    }
  }

  private static final class Stock {

    /**
     * category.
     */
    private final String category;

    /**
     * sub category.
     */
    private final String subCategory;

    /**
     * copies in stock.
     */
    private final String copiesInStock;

    /**
     * cover image url.
     */
    private final String coverImage;

    /**
     * availability.
     */
    private final String availability;

    private Stock(final String categoryName, final String subCatName,
                  final int copies, final String url, final int daysAvailable) {
      category = categoryName;
      subCategory = subCatName;
      copiesInStock = copies + "";
      coverImage = url;
      availability = daysAvailable + "";
    }

    public String getCategory() {
      return category;
    }

    public String getSubCategory() {
      return subCategory;
    }

    public String getCopiesInStock() {
      return copiesInStock;
    }

    public String getCoverImage() {
      return coverImage;
    }

    public String getAvailability() {
      return availability;
    }

  }

  /**
   * testing the method duplicateBookStore and recreate bookstore.xml.
   * @param args unused.
   * @throws Exception exception
   */
  public static void main(final String[] args) throws Exception {
    BookStoreFactory bsf = BookStoreFactory.getInstance();
    bsf.duplicateBookstore("bookstore.xml", "bookstore-copy.xml");
  }

}
