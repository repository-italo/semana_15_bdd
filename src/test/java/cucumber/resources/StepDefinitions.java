package cucumber.resources;

import cucumber.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
    private LoginPage loginPage;
    private final String url = "https://the-internet.herokuapp.com/login";

    @Given("User is on Login Page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(url);
    }

    @When("User enter a wrong password in Password Field")
    public void user_enter_a_wrong_password_in_password_field() {
        loginPage.preencherCampo("//*[@id=\"password\"]", "outrasenha");
    }
    @Then("User should not be able to pass out")
    public void user_should_not_be_able_to_pass_out() {
        loginPage.paginaCerta(url);
        loginPage.paginaContem("//*[@id=\"flash\"]", "Your password is invalid!");
    }

    @When("User enter the correct name in Name Field")
    public void user_enter_the_correct_name_in_name_field() {
        loginPage.preencherCampo("//*[@id=\"username\"]", "tomsmith");

    }


    @When("User enter the correct password in Password Field")
    public void user_enter_the_correct_password_in_password_field() {
        loginPage.preencherCampo("//*[@id=\"password\"]", "SuperSecretPassword!");
    }

    @When("User click in the Login Button")
    public void user_click_in_the_login_button(){
        loginPage.clicar("/html/body/div[2]/div/div/form/button");
    }


    @Then("User should be redirectioned to Safe Space Page")
    public void user_should_be_redirectioned_to_safe_space_page() {
        loginPage.paginaCerta("https://the-internet.herokuapp.com/secure");
        loginPage.paginaContem(
                "/html/body/div[2]/div/div/h4",
                "Welcome to the Secure Area. When you are done click logout below.");
    }

    // Scenario 2



}
