package stepdefinitions;

import java.util.List;
import java.util.Map;
 
import org.junit.Assert;
 
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class StepDefinitions {
    private static final String BASE_URL = "http://localhost:8081/";
    
    private static String token;
    private static Response response;
    private static String jsonString;
    
    
    //  @Given("I am an authorized user")
    //  public void iAmAnAuthorizedUser() {
    
    //  RestAssured.baseURI = BASE_URL;
    //  RequestSpecification request = RestAssured.given();
    
    //  request.header("Content-Type", "application/json");
    //  response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
    //  .post("/Account/v1/GenerateToken");
    
    //  String jsonString = response.asString();
    //  token = JsonPath.from(jsonString).get("token");
    
    //  }
    
    //  @Given("A list of books are available")
    //  public void listOfBooksAreAvailable() {
    //  RestAssured.baseURI = BASE_URL;
    //  RequestSpecification request = RestAssured.given();
    //  response = request.get("/BookStore/v1/Books");
    
    //  jsonString = response.asString();
    //  List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
    //  Assert.assertTrue(books.size() > 0);
    
    //  bookId = books.get(0).get("isbn");    
    //  }


    @When("User sends their data username {string} firstname {string} lastname {string} email {string} password {string} admin {string}")
    public void user_sends_their_data(String username, String firstname, String lastname, String email, String password, String admin) {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
    
        response = request.body("{ \"username\": \"" + username + "\", " +
        "\"password\": \"" + password + "\", " +
        "\"firstName\": \"" + firstname + "\", " +
        "\"lastName\": \"" + lastname + "\", " +
        "\"email\": \"" + email + "\", " +
        "\"createdBy\": \"" + admin + "\", " +
        "\"updatedBy\": \"" + admin + "\"}")
        .post("/api/v1/users");
    }
    
    @Then("User profile should be created")
    public void user_profile_should_be_created() {
        //Assert.assertNotNull(response.getBody());
        Assert.assertNotNull(null);
    }
    
    @When("User requests data")
    public void user_requests_data() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        
        request.header("Content-Type", "application/json");
        
        response = request.get("/api/v1/users");
    }
    
    @Then("All users are displayed")
    public void all_users_are_displayed() {
        Assert.assertNotNull(response.getBody());
    }
}