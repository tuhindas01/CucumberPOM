Feature: Contact Us Feature

Scenario Outline: Contact Us Scenario with different set of data
Given user navigates to contact us page
When user fills the form from the given sheetname ContactUs and rownumber <RowNumber>
And user clicks on send button
Then it shows successfull message "Your message has been successfully sent to our team."

Examples:
|SheetName|RowNumber|
|ContactUs|0|
|ContactUs|1|