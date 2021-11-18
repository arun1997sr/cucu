$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/Amazon.feature");
formatter.feature({
  "name": "search mobile in amazon",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@aa"
    }
  ]
});
formatter.scenario({
  "name": "search mobile in amazon",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@aa"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "launch the browser",
  "keyword": "Given "
});
formatter.match({
  "location": "AmazonSearch.launch_the_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "search mobile in search bar",
  "keyword": "When "
});
formatter.match({
  "location": "AmazonSearch.search_mobile_in_search_bar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate the mobile page",
  "keyword": "Then "
});
formatter.match({
  "location": "AmazonSearch.validate_the_mobile_page()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});