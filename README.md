# Automation
AMAZON.com Website Automation Test script
### Test Case Description
1- Go to https:www.amazon.com/
2- Log in with your credentials;
- check that user signs in

3- Search "Samsung" on the search page

4- Go to the Second Page
- check that you are in the second page

5- Click the third item from the list

6- Add to the wish list

7- Go to the Wish List from the member details

8- Delete the wish list

9- Check that item is deleted on your wish list
- check that deleted item is same as selected item

### How to execute test
Open a command window and run:
```sh
    $ mvn clean test
```

### Reports
The directory of the executed report in the following path;
 -  test-output/index.html
