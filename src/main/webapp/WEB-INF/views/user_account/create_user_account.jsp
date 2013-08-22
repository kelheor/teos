<div class="container">


    <form ng-controller="UserAccountController">
        <input type="hidden" ng-model="user.userAccountId"/>
        <label>Username:</label>
        <input type="text" ng-model="user.username" required />
        <label>Password</label>
        <input type="text" ng-model="user.password" required /> <br/>
        <input type="submit" value="Submit" ng-click="register()" />
    </form>

</div> <!-- /container -->

<script src="/resources/js/controllers/user_account_controller.js"></script>