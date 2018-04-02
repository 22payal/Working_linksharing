<html lang="en">
<head>

    -    <meta charset="UTF-8">
    -    <meta name="viewport" content="width=device-width, initial-scale=1">
    -
    -    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    -    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    -
    -    <title>Home</title>
    +    <title></title>
    +    <meta name="layout" content="main">

</head>

<body>

-<nav class="navbar navbar-expand-lg navbar  ">
    -
    -    <a class="navbar-brand col-lg-2 " href="#"><h2 style="margin-top: 0px">Link Sharing</h2></a>
    -
    -    <p class="col-lg-7"></p>
    -
    -    <form class="navbar-form navbar-left" action="/action_page.php">
        -        <div class="input-group">
            -            <input type="text" class="form-control" placeholder="Search...">
            -            <div class="input-group-btn">
                -                <button class="btn btn-default" type="submit">
                    -                    <i class="glyphicon glyphicon-search"></i>
                    -                </button>
                -            </div>
            -        </div>
        -    </form>
    -</nav>
-
<div class=" container">
    <div class="col-lg-6">
        <div class="col-lg-12" style="margin-top: 25px">

            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #007efc">
                    <p>
                        +
                    <h3 style="color:white">Recent Shares</h3></p>
                </div>
                -                <div class="panel-body  ">
                -                    <div class="col-lg-12">
                    -                        <div class="col-lg-3" style="margin-top: 25px">
                        -                            <i class="fa fa-user fa-5x" aria-hidden="true"></i>
                        -
                        -                        </div>
                    -                        <div class="col-lg-9">
                        -                            <p><h6>User's FullName  <span style="color: darkgray">@username</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                        -                            <p><h5>An overview of the topic is written here for basic understanding...............................
                        -                            ...............................
                        -                            ...............................</h5></p>
                        -
                        -                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                        -                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                        -                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                        -                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">View Topic</a></span>
                        -
                        -                        </div>
                    -                    </div>
                -
                -                    <div class="col-lg-12">
                    -                        <hr>
                    -                    </div>

                +                <div class="panel-body  ">
                    <div class="col-lg-12">
                        -                        <div class="col-lg-3" style="margin-top: 25px">
                        -                            <i class="fa fa-user fa-5x" aria-hidden="true"></i>
                        -
                        -                        </div>
                        -                        <div class="col-lg-9">
                        -                            <p><h6>User's FullName  <span style="color: darkgray">@username</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                        -                            <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>
                        -
                        -                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                        -                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                        -                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                        -                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">View Topic</a></span>
                        -
                        -                        </div>
                        +                        <g:each in="${resource.Resource.getRecentShares()}" var="recentShares">
                        +                            <div class="col-lg-3" style="margin-top: 25px">
                            +                                <i class="fa fa-user fa-5x" aria-hidden="true"></i>
                            +
                            +                            </div>
                        +
                        +                            <div class="col-lg-9">
                            +                                <p>${recentShares.createdBy.name}  <span
                                    +                                        style="color: darkgray">@${recentShares.createdBy.username}</span><span
                                    +                                        class="pull-right"
                                    +                                        style="margin-right: 0px;color: #007efc;font-size: small">${recentShares.topic.name}</span>
                                +                                </p>
                            +
                            +                                <p>${recentShares.description}</p>
                            +
                            +                                <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                            +                                <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                            +                                <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                            +                                <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"
                                                                                                                                  +                                                                                                     style="color: #007efc;font-size: small">View Topic</a>
                                +                                </span>
                            +                            </div>
                        +                            <hr>
                        +                        </g:each>
                    </div>

                    -
                </div>
            </div>

            </div>
            +
            <div class="col-lg-12" style="margin-top: 25px">

                <div class=" panel panel-default     ">
                    @@ -109,22 +75,28 @@
                    <i class="fa fa-user fa-5x" aria-hidden="true"></i>

                </div>
                +
                <div class="col-lg-9">
                    -                            <p><h6>User's FullName  <span style="color: darkgray">@username</span><span class="pull-right" style="margin-right: 0px;color: #007efc;font-size: small">Topic Name</span></h6> </p>
                    -                            <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>
                    +                            <g:each in="${resource.Resource.getTopPost()}" var="topPosts">
                    +                                <p>${topPosts.createdBy}<span style="color: darkgray">@${topPosts.createdBy}</span><span
                            +                                        class="pull-right"
                            +                                        style="margin-right: 0px;color: #007efc;font-size: small">${topPosts.topicName}</span>
                        +                                </p>
                    +
                    +                                <p><h5>An overview of the topic is written here for basic understanding...............................</h5></p>


-                            <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                    -                            <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                    -                            <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                    -                            <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#" style="color: #007efc;font-size: small">View Topic</a></span>
                    +                                <i class="fa fa-facebook-official fa-lg" aria-hidden="true"></i>
                    +                                <i class="fa fa-google fa-lg" aria-hidden="true"></i>
                    +                                <i class="fa fa-twitter fa-lg" aria-hidden="true"></i>
                    +                                <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"
                                                                                                                          +                                                                                                     style="color: #007efc;font-size: small">View Topic</a>
                        +                                </span>
                    +                            </g:each>

                </div>
            </div>

            -
            -
            -
        </div>
    </div>

    @@ -138,28 +110,37 @@
    <div class=" panel panel-default  ">
        <div class="panel-heading " style="background:#007efc">
            <p>
                +
            <h3 style="color:white">Login</h3></p>
        </div>
        +
    <div class="panel-body ">
        <g:form controller="login" action="loginhandler" method="post">
            <div class="form-group col-lg-10">
                <label>Username</label>
                -                            <input class="form-control" type="text" name="loginusername" placeholder="enter your username">
                -                        </div><div class="col-lg-2"></div>
            +                            <input class="form-control" type="text" name="loginusername"
                                                +                                   placeholder="enter your username">
            +                        </div>
            +
            +                        <div class="col-lg-2"></div>
            +
            <div class="form-group col-lg-10">
                <label>Password</label>
                -                            <input class="form-control" type="password" name="loginpassword" placeholder="enter your password">
                +                            <input class="form-control" type="password" name="loginpassword"
                                                    +                                   placeholder="enter your password">

            </div>
            +
            <div class="col-lg-12"></div>
            -                        <div class="form-group col-lg-5" >
            +
            +                        <div class="form-group col-lg-5">
                                         <p><a href="#">Forgot Password</a></p>
                                     </div>
            -                        <div  class="form-group col-lg-10">
            +
            +                        <div class="form-group col-lg-10">
                                         <input type="submit" class="form-control btn-primary" style="background:#007efc">
                                     </div>

            -
        </g:form>

    </div>
        @@ -170,58 +151,66 @@
        <div class=" panel panel-default ">
            <div class="panel-heading  " style="background:#007efc">
                <p>
                    +
                <h3 style="color:white">Registration</h3></p>
            </div>
            +
        <div class="panel-body ">
            <g:form controller="login" action="register" method="post">
                <div class="form-group col-lg-10">
                    <label>First Name</label>
                    -                            <input class="form-control" type="text" name="firstname" placeholder="enter your first name">
                    -                        </div><div class="col-lg-2"></div>
                +                            <input class="form-control" type="text" name="firstname"
                                                    +                                   placeholder="enter your first name">
                +                        </div>
                +
                +                        <div class="col-lg-2"></div>
                +
                <div class="form-group col-lg-10">
                    -                            <label>Last name </label>
                    +                            <label>Last name</label>
                    <input class="form-control" type="text" name="lastname" placeholder="enter your last name">

                </div>
                +
                <div class="form-group col-lg-10">
                    -                            <label>Email </label>
                    +                            <label>Email</label>
                    <input class="form-control" type="email" name="email" placeholder="enter your email">

                </div>
                +
                <div class="form-group col-lg-10">
                    -                            <label>Username </label>
                    -                            <input class="form-control" type="text" name="username" >
                    +                            <label>Username</label>
                    +                            <input class="form-control" type="text" name="username">

                </div>

                <div class="form-group col-lg-10">
                    -                            <label>Password </label>
                    +                            <label>Password</label>
                    <input class="form-control" type="password" name="password" placeholder="enter password">

                </div>
                +
                <div class="form-group col-lg-10">
                    -                            <label>Confirm Password </label>
                    -                            <input class="form-control" type="password" name="confirmpassword" placeholder="confirm your  password">
                    +                            <label>Confirm Password</label>
                    +                            <input class="form-control" type="password" name="confirmpassword"
                                                        +                                   placeholder="confirm your password">

                </div>
                +
                <div class="form-group col-lg-10">
                    -                            <label>Photo </label>
                    -                            <input class="form-control" type="file" name="photo" >
                    +                            <label>Photo</label>
                    +                            <input class="form-control" type="file" name="photo">

                </div>

                -                        <div  class="form-group col-lg-10">
                +                        <div class="form-group col-lg-10">
                                             <input type="submit" class="form-control btn-primary" style="background:#007efc">
                                         </div>

                -
            </g:form>

        </div>
        </div>


    </div>
    </div>