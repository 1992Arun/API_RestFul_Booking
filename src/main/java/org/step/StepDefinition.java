package org.step;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.utility.Builder;
import org.utility.EndPoints;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition extends Builder {

	public static int bookingID;

	public static String token;

	public static RequestSpecification spec;

	public static Response response;

	@Given("I give the baseURI and request Specifications")
	public void i_give_the_baseURI_and_request_Specifications() {

		spec = RestAssured.given().spec(getRequestSpecBuilder());

	}

	@When("I send the {string} request with {string} endpoint")
	public void i_send_the_request_with_endpoint(String string, String string2) throws ParseException {

		EndPoints res = EndPoints.valueOf(string2);

		String endPoint = res.getResource();

		if (string.equalsIgnoreCase("GET")) {

			response = spec.when().get(endPoint).then().assertThat().extract().response();

		} else if (string.equalsIgnoreCase("POST")) {

			response = spec.when().post(endPoint).then().assertThat().extract().response();

			JsonPath path = new JsonPath(getResponseBody(response));

			bookingID = path.get("bookingid");

		} else if (string.equalsIgnoreCase("AUTH")) {

			response = spec.body(getAuthBody())

					.when().post(endPoint).then().assertThat().extract().response();

			JSONParser js = new JSONParser();

			Object parse = js.parse(getResponseBody(response));

			JSONObject ob = (JSONObject) parse;

			token = (String) ob.get("token");

		} else if (string.equalsIgnoreCase("PUT")) {

			response = spec.when().put(endPoint + bookingID).then().assertThat().extract().response();

		} else if (string.equalsIgnoreCase("PATCH")) {

			response = spec.when().patch(endPoint + bookingID).then().assertThat().extract().response();

		} else if (string.equalsIgnoreCase("DELETE")) {

			response = spec.cookie("token", token).when().delete(endPoint + bookingID).then().assertThat().extract()
					.response();

		}

	}

	@Then("I verify the {string} response code {int}")
	public void i_verify_the_response_code(String string, int int1) {

		if (string.equalsIgnoreCase("GET")) {

			Assert.assertEquals(getResponseCode(response), int1);

			System.out.println(int1);

		} else if (string.equalsIgnoreCase("POST")) {

			Assert.assertEquals(getResponseCode(response), int1);

			System.out.println(int1);

			System.out.println(getResponseBody(response));

		} else if (string.equalsIgnoreCase("PUT")) {

			Assert.assertEquals(getResponseCode(response), int1);

			System.out.println(int1);

			System.out.println(getResponseBody(response));

		} else if (string.equalsIgnoreCase("PATCH")) {

			Assert.assertEquals(getResponseCode(response), int1);

			System.out.println(int1);

			System.out.println(getResponseBody(response));

		} else if (string.equalsIgnoreCase("DELETE")) {

			Assert.assertEquals(getResponseCode(response), int1);

			System.out.println(int1);

		}

	}

	@Given("I give the {string} body")
	public void i_give_the_body(String string) {

		if (string.equalsIgnoreCase("POSTRequest")) {

			spec.body(postRequestBody());

		} else if (string.equalsIgnoreCase("PUTRequest")) {

			spec.cookie("token", token);

			spec.body(putRequestBody());

		} else if (string.equalsIgnoreCase("PATCHRequest")) {

			spec.cookie("token", token);

			spec.body(patchRequestBody());

		}

	}

}
