package hamcrest.exp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import java.util.*;

import static hamcrest.exp.IsPositiveInteger.isAPositiveInteger;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.object.HasToString.hasToString;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;

public class HamCrestExp {

	//string
	@Test
	public void given2Strings_whenEqual_thenCorrect() {
		String a = "foo";
		String b = "FOO";
		assertThat(a, equalToIgnoringCase(b));
	}

	//objs
	@Test
	public void givenBean_whenToStringReturnsRequiredString_thenCorrect(){
		Person person=new Person("Barrack", "Washington");
		String str=person.toString();
		assertThat(person,hasToString(str));
	}

	@Test
	public void given2Classes_whenOneInheritsFromOther_thenCorrect(){
		assertThat(Cat.class,typeCompatibleWith(Animal.class));
	}

	class Cat extends Animal{}
	class Animal {}

	// bean
	@Test
	public void givenBean_whenHasValue_thenCorrect() {
		Person person = new Person("Baeldung", "25");
		// need public get method, otherwise failed
		assertThat(person, hasProperty("name"));
	}

	@Test
	public void givenBean_whenHasCorrectValue_thenCorrect() {
		Person person = new Person("Baeldung", "New York");
		// get method can't be public, I think its useless
		assertThat(person, hasProperty("address", equalTo("New York")));
	}

	@Test
	public void given2Beans_whenHavingSameValues_thenCorrect() {
		Person person1 = new Person("Baeldung", "New York");
		Person person2 = new Person("Baeldung", "New York");
		assertThat(person1, samePropertyValuesAs(person2));
	}



	// collection
	@Test
	public void givenCollection_whenEmpty_thenCorrect() {
		List<String> emptyList = new ArrayList<>();
		assertThat(emptyList, empty());
	}

	@Test
	public void givenAList_whenChecksSize_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList(
				"collections", "beans", "text", "number");
		assertThat(hamcrestMatchers, hasSize(4));
	}

	@Test
	public void givenArray_whenChecksSize_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers, arrayWithSize(4));
	}

	@Test
	public void givenAListAndValues_whenChecksListForGivenValues_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList(
				"collections", "beans", "text", "number");
		assertThat(hamcrestMatchers,
				containsInAnyOrder("beans", "text", "collections", "number"));
	}

	@Test
	public void givenAListAndValues_whenChecksListForGivenValuesWithOrder_thenCorrect() {
		List<String> hamcrestMatchers = Arrays.asList(
				"collections", "beans", "text", "number");
		assertThat(hamcrestMatchers,
				contains("collections", "beans", "text", "number"));
	}

	@Test
	public void givenArrayAndValue_whenValueFoundInArray_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers, hasItemInArray("text"));
	}

	@Test
	public void givenValueAndArray_whenValueIsOneOfArrayElements_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat("text", isOneOf(hamcrestMatchers));
	}

	@Test
	public void givenValueAndArray_whenValueFoundInArray_thenCorrect() {
		String[] array = new String[] { "collections", "beans", "text",
				"number" };
		assertThat("beans", isIn(array));
	}

	@Test
	public void givenArrayAndValues_whenValuesFoundInArray_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers,
				arrayContainingInAnyOrder("beans", "collections", "number",
						"text"));
	}

	@Test
	public void givenArrayAndValues_whenValuesFoundInArrayInOrder_thenCorrect() {
		String[] hamcrestMatchers = { "collections", "beans", "text", "number" };
		assertThat(hamcrestMatchers,
				arrayContaining("collections", "beans", "text", "number"));
	}

	@Test
	public void givenMapAndKey_whenKeyFoundInMap_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("blogname", "baeldung");
		assertThat(map, hasKey("blogname"));
	}

	@Test
	public void givenMapAndValue_whenValueFoundInMap_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("blogname", "baeldung");
		assertThat(map, hasValue("baeldung"));
	}

	@Test
	public void givenMapAndEntry_whenEntryFoundInMap_thenCorrect() {
		Map<String, String> map = new HashMap<>();
		map.put("blogname", "baeldung");
		assertThat(map, hasEntry("blogname", "baeldung"));
	}

	//number
	@Test
	public void givenAnInteger_whenGreaterThan0_thenCorrect() {
		assertThat(1, greaterThan(0));
	}

	@Test
	public void givenAnInteger_whenGreaterThanOrEqTo5_thenCorrect() {
		assertThat(5, greaterThanOrEqualTo(5));
	}

	@Test
	public void givenAnInteger_whenLessThan0_thenCorrect() {
		assertThat(-1, lessThan(0));
	}
	@Test
	public void givenAnInteger_whenLessThanOrEqTo5_thenCorrect() {
		assertThat(-1, lessThanOrEqualTo(5));
	}
	@Test
	public void givenADouble_whenCloseTo_thenCorrect() {
		assertThat(1.2, closeTo(1, 0.5));
	}

	//text

	@Test
	public void givenString_whenEmpty_thenCorrect() {
		String str = "";
		assertThat(str, isEmptyString());
	}

	@Test
	public void givenString_whenEmptyOrNull_thenCorrect() {
		String str = null;
		assertThat(str, isEmptyOrNullString());
	}

	@Test
	public void given2Strings_whenEqualRegardlessWhiteSpace_thenCorrect() {
		String str1 = "text";
		String str2 = " text ";
		assertThat(str1, equalToIgnoringWhiteSpace(str2));
	}

	@Test
	public void givenString_whenContainsGivenSubstring_thenCorrect() {
		String str = "calligraphy";
		assertThat(str, stringContainsInOrder(Arrays.asList("call", "graph")));
	}

	// core api -- is, not,
	@Test
	public void given2Strings_whenIsEqualRegardlessWhiteSpace_thenCorrect() {
		String str1 = "text";
		String str2 = " text ";
		assertThat(str1, is(equalToIgnoringWhiteSpace(str2)));
	}

	@Test
	public void given2Strings_whenIsEqual_thenCorrect() {
		String str1 = "text";
		String str2 = "text";
		assertThat(str1, is(str2));
	}

	@Test
	public void given2Strings_whenNotEqual_thenCorrect() {
		String str1 = "text";
		String str2 = "texts";
		assertThat(str1, not(str2));
	}

	@Test
	public void givenAStrings_whenContainsAnotherGivenString_thenCorrect() {
		String str1 = "calligraphy";
		String str2 = "call";
		assertThat(str1, containsString(str2));
	}

	@Test
	public void givenAString_whenStartsWithAnotherGivenString_thenCorrect() {
		String str1 = "calligraphy";
		String str2 = "call";
		assertThat(str1, startsWith(str2));
	}

	@Test
	public void givenAString_whenEndsWithAnotherGivenString_thenCorrect() {
		String str1 = "calligraphy";
		String str2 = "phy";
		assertThat(str1, endsWith(str2));
	}

	@Test
	public void given2Objects_whenSameInstance_thenCorrect() {
		Cat cat=new Cat();
		assertThat(cat, sameInstance(cat));
	}

	@Test
	public void givenAnObject_whenInstanceOfGivenClass_thenCorrect() {
		Cat cat=new Cat();
		assertThat(cat, instanceOf(Cat.class));
	}

	@Test
	public void givenList_whenEachElementGreaterThan0_thenCorrect() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		int baseCase = 0;
		assertThat(list, everyItem(greaterThan(baseCase)));
	}

	@Test
	public void givenString_whenNotNull_thenCorrect() {
		String str = "notnull";
		assertThat(str, notNullValue());
	}

	@Test
	public void givenString_whenMeetsAnyOfGivenConditions_thenCorrect() {
		String str = "calligraphy";
		String start = "call";
		String end = "foo";
		assertThat(str, anyOf(startsWith(start), containsString(end)));
	}

	@Test
	public void givenString_whenMeetsAllOfGivenConditions_thenCorrect() {
		String str = "calligraphy";
		String start = "call";
		String end = "phy";
		assertThat(str, allOf(startsWith(start), endsWith(end)));
	}

	@Test
	public void givenInteger_whenAPositiveValue_thenCorrect() {
		int num = 1;
		assertThat(num, isAPositiveInteger());
	}

}

// custom matcher
class IsPositiveInteger extends TypeSafeMatcher<Integer> {

	public void describeTo(Description description) {
		description.appendText("a positive integer");
	}

	@Factory
	public static Matcher<Integer> isAPositiveInteger() {
		return new IsPositiveInteger();
	}

	@Override
	protected boolean matchesSafely(Integer integer) {
		return integer > 0;
	}

}

@AllArgsConstructor
class Person {
	private String name;
	private String address;

	 String getName() {
		return name;
	}

	 String getAddress() {
		return address;
	}
}