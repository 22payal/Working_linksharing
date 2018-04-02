<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Home</title>

</head>

<body>

<nav class="navbar navbar-expand-lg navbar  ">

    <a class="navbar-brand col-lg-2 " href="#"><h2 style="margin-top: 0px">Link Sharing</h2></a>

    <p class="col-lg-7"></p>

    <form class="navbar-form navbar-left" action="/action_page.php">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search...">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit">
                    <i class="glyphicon glyphicon-search"></i>
                </button>
            </div>
        </div>
    </form>
</nav>

<div class=" container">
    <div class="col-lg-6">
        <div class="col-lg-12" style="margin-top: 25px">

            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #007efc">
                    <p>
                    <h3 style="color:white">Recent Shares</h3></p>
                </div>
                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <p><h6>User's FullName  <span style="color: darkgray">@username</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                            <p><h5>An overview of the topic is written here for basic understanding...............................
                        ...............................
                        ...............................</h5></p>

                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">View Topic</a></span>

                        </div>
                    </div>

                    <div class="col-lg-12">
                        <hr>
                    </div>

                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <p><h6>User's FullName  <span style="color: darkgray">@username</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                            <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>

                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">View Topic</a></span>

                        </div>
                    </div>


                </div>
            </div>

        </div>
        <div class="col-lg-12" style="margin-top: 25px">

            <div class=" panel panel-default     ">
                <div class="panel-heading  col-lg-12" style="background: #007efc">
                    <h3 style="color:white " class="col-lg-8">Top Posts</h3>


                    <select name="time" class=" col-lg-3 " style=" margin-top: 25px">
                        <option value="today">Today</option>
                        <option value="1 week">1 Week</option>
                        <option value="1 month">1 Month</option>
                        <option value="1 year">1 Year</option>
                    </select>

                </div>

                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <p><h6>User's FullName  <span style="color: darkgray">@username</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                            <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>


                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">View Topic</a></span>

                        </div>
                    </div>




                </div>
            </div>

        </div>

    </div>

    <div class="col-lg-6">

        <div class="panel-body ">
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

        </div>




        <div class="panel-body ">
            <g:form controller="login" action="register" method="post">
                <div class="form-group col-lg-10">
                    <label>First Name</label>
                    <input class="form-control" type="text" name="firstName" placeholder="enter your first name">
                </div><div class="col-lg-2"></div>
                <div class="form-group col-lg-10">
                    <label>Last name </label>
                    <input class="form-control" type="text" name="lastName" placeholder="enter your last name">

                </div>
                <div class="form-group col-lg-10">
                    <label>Email </label>
                    <input class="form-control" type="email" name="email" placeholder="enter your email">

                </div>
                <div class="form-group col-lg-10">
                    <label>Username </label>
                    <input class="form-control" type="text" name="userName" >

                </div>

                <div class="form-group col-lg-10">
                    <label>Password </label>
                    <input class="form-control" type="password" name="password" placeholder="enter password">

                </div>
                <div class="form-group col-lg-10">
                    <label>Confirm Password </label>
                    <input class="form-control" type="password" name="confirmPassword" placeholder="confirm your  password">

                </div>

                <div  class="form-group col-lg-10">
                    <input type="submit" class="form-control btn-primary" style="background:#007efc">
                </div>


            </g:form>
        </div>

    </div>

</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>