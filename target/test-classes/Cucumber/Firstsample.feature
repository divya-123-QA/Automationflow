Feature:Order the product in E-commerce application

Background:
Given Go to URL 

@Additem
Scenario Outline:Select the product and confirm the order
Given user enters <username> and <password>
When user select the product <name> and add to cart
And confirm the "ZARA COAT 3" is displayed in cart section
 And make payment with "India","123","test"
Then user should get the confirmation of order msg
Examples:
| username | password | name |
| rav123@gmail.com | Money08$ | ZARA COAT 3 |
    
