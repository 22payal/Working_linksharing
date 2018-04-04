
        <g:form controller="login" action="loginHandler" method="post">
            <div class="form-group col-lg-10">
                <label>Username</label>
                <input class="form-control" type="text" name="loginusername" placeholder="enter your username">
            </div><div class="col-lg-2"></div>
            <div class="form-group col-lg-10">
                <label>Password</label>
                <input class="form-control" type="password" name="loginpassword" placeholder="enter your password">

            </div>
            <div class="col-lg-12"></div>
            <div class="form-group col-lg-5" >
                <p><a href="#">Forgot Password</a></p>
            </div>
            <div  class="form-group col-lg-10">
                <input type="submit" class="form-control btn-primary" style="background:#007efc">
            </div>


        </g:form>
