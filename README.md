# codefellowship

<h1>Welcome to codefellowship the app</h1><span>by Shane Gable</span>

<h2>Instructions</h2>
<ul>
<li>Navigage to localhost:8080</li>
<li>Click on the 'register' link, or log in if you have already done so</li>
<li>Enter your information and click submit</li>
<li>You will now be on your profile page where you can view your information</li>
<li>You may add a post and view your posts from this page.</li>
<li>To create a post simply type into the text box and click submit</li>
<li>Enjoy the app!</li>
</ul>

Project:

- [ ] Ensure that users can’t perform SQL injection or HTML injection with their posts.

- [x] Allow users to follow other users. Following a user means that their posts show up in the logged-in user’s feed, where they can see what all of their followed users have posted recently.

- [x] Ensure there is some way (like a users index page) that a user can discover other users on the service.

- [x] On a user profile page that does NOT belong to the currently logged-in user, display a “Follow” button. When a user clicks that follow button, the logged-in user is now following the viewed-profile-page user.
note: this will require a self-join on ApplicationUsers.

- [x] A user can visit a url (like /feed) to view all of the posts from the users that they follow.

- [x] Each post should have a link to the user profile of the user who wrote the post.

- [x] A splash page with basic information about the site

- [x] The ability for users to register for new accounts and log in.

- [x] The ability for logged-in users to create posts.

- [x] The ability to see a user’s posts, along with their profile information and a default profile picture, on their profile page.

- [x] A pleasing design throughout the site.

- [x] Thymeleaf templates & fragments used appropriately to keep view code DRY.

- [x] Smooth error handling with appropriate responses to bad requests.

- [x] Integration testing on (at minimum) the splash page, login, and sign up routes.