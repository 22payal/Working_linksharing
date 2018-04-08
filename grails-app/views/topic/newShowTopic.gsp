<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Title</title>

    <style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        font-family: Arial, Helvetica, sans-serif;
    }

    .topnav {
        overflow: hidden;
        background-color: #e9e9e9;
    }

    .topnav a {
        float: left;
        display: block;
        color: black;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    .topnav a:hover {
        background-color: #ddd;
        color: black;
    }

    .topnav a.active {
        background-color: #2196F3;
        color: white;
    }

    .topnav .search-container {
        float: right;
    }

    .topnav input[type=text] {
        padding: 6px;
        margin-top: 8px;
        font-size: 17px;
        border: none;
    }

    .topnav .search-container button {
        float: right;
        padding: 6px 10px;
        margin-top: 8px;
        margin-right: 16px;
        background: #ddd;
        font-size: 17px;
        border: none;
        cursor: pointer;
    }

    .topnav .search-container button:hover {
        background: #ccc;
    }

    @media screen and (max-width: 600px) {
        .topnav .search-container {
            float: none;
        }

        .topnav a, .topnav input[type=text], .topnav .search-container button {
            float: none;
            display: block;
            text-align: left;
            width: 100%;
            margin: 0;
            padding: 14px;
        }

        .topnav input[type=text] {
            border: 1px solid #ccc;
        }
    }
    </style>
</head>

<body>
<div class="container">
    <div class="col-lg-6">
        <div class="col-lg-12">
            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #1b1e21">
                    <p>
                    <h3 style="color:white">Topic:"Grails"</h3></p>
                </div>
                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5><a href="#">Grails</a> <span STYLE="color: #9d9d9d ">(PRIVATE)</span></h5>
                            </div>
                            <div class="col-lg-12">
                                <div class="col-lg-5">
                                    <p style="color: #9d9d9d">@ajay</p>
                                    <p1><a href="#">subscribe</a></p1>
                                </div>
                                <div class="col-lg-5">
                                    <p style="color: #9d9d9d">subscriptions</p>
                                    <p1 style="color: #2e6da4">5</p1>


                                </div>
                                <div class="col-lg-2">
                                    <p style="color: #9d9d9d">post</p>
                                    <p1 style="color: #2e6da4">5</p1>
                                </div>

                            </div>


                        </div>
                    </div>


                </div>
            </div>


        </div>
        <div class="col-lg-12">
            <div class=" panel panel-default     ">
                <div class="panel-heading " style="background: #1b1e21">
                    <p>
                    <h3 style="color:white">User:"Grails"</h3></p>
                </div>
                <div class="panel-body  ">
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5> ajay singh jodah </h5>
                                <p STYLE="color: #9d9d9d ">@ajay</p>
                            </div>
                            <div class="col-lg-12">
                                <hr>
                            </div>
                            <div class="col-lg-12">
                                <div class="col-lg-6">
                                    <p style="color: #9d9d9d">subscriptions</p>
                                    <p1><a href="#">50</a></p1>
                                </div>
                                <div class="col-lg-6">
                                    <p style="color: #9d9d9d">topics</p>
                                    <p1 style="color: #2e6da4">30</p1>


                                </div>


                            </div>


                        </div>
                    </div>
                    <div class="col-lg-12">
                        <hr>
                    </div>
                    <div class="col-lg-12">
                        <div class="col-lg-3" style="margin-top: 25px">
                            <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                        </div>
                        <div class="col-lg-9">
                            <div class="col-lg-12">
                                <h5> payal nigam</h5>
                                <p STYLE="color: #9d9d9d ">@payal</p>
                            </div>
                            <div class="col-lg-12">
                                <hr>
                            </div>
                            <div class="col-lg-12">
                                <div class="col-lg-6">
                                    <p style="color: #9d9d9d">subscriptions</p>
                                    <p1><a href="#">50</a></p1>
                                </div>
                                <div class="col-lg-6">
                                    <p style="color: #9d9d9d">topics</p>
                                    <p1 style="color: #2e6da4">30</p1>


                                </div>


                            </div>


                        </div>
                    </div>


                </div>
            </div>

        </div>
    </div>
    <div class="col-lg-6">
        <div class="col-lg-12">
            <div class="col-lg-12">
                <div class=" panel panel-default     ">
                    <div class="panel-heading col-lg-12" style="background: #1b1e21;">
                        <div class="col-lg-4">
                            <h3 style="color:white">Posts:"Grails"</h3>
                        </div>

                        <div class="col-lg-8">
                            <div class="topnav pull-rigth " style="background-color: #1b1e21">

                                <div class="search-container">
                                    <form action="/action_page.php">
                                        <input type="text" placeholder="Search.." name="search">
                                        <button type="submit" style="background-color: #1b1e21;margin-right: 0px"><i
                                                class="fa fa-search"
                                                style="font-size:25px;color:white;background-color: #1b1e21"></i>
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>


                    </div>
                    <div class="panel-body  ">
                        <div class="col-lg-12">
                            <div class="col-lg-3" style="margin-top: 25px">
                                <i class="fa fa-user-circle fa-5x" aria-hidden="true"></i>

                            </div>
                            <div class="col-lg-9">
                                <div class="col-sm-12">
                                    <br>

                                    <span>Uday Pratap Singh &nbsp;&nbsp;&nbsp;&nbsp;<small class="text-muted">@Uday  5min</small>

                                        <a href="#" class="pull-right">Grails</a>
                                        <br><br>
                                        <div class="col-lg-12">
                                            <p>akjbcadbcajncanclkaccksdm csdlndcskdncpsdmdc sdlcnklsdclkddnc sdlcnsdmcpsdpmc esdlc ldnclksdncsld sdlcnsdcklsdcklsdnc scsdncsclsd csldnfklfc </p>
                                        </div>



                                    </span>
                                    <div>
                                        <i class="fa fa-facebook-square fa-lg" aria-hidden="true"></i>
                                        <i class="fa fa-google-plus fa-lg" aria-hidden="true"></i>
                                        <i class="fa fa-twitter-square fa-lg" aria-hidden="true"></i>
                                        <span class="pull-right" style="margin-right: 0px;color: #007efc"><a href="#"
                                                                                                             style="color: #007efc;font-size: 75%">Download</a>
                                            <a href="#" style="color: #007efc;font-size: 75%"> Mark as Read</a>
                                            <a href="#" style="color: #007efc;font-size: 75%"> View Topic</a></span>
                                    </div>
                                </div>


                            </div>
                        </div>


                    </div>
                </div>


            </div>

        </div>
    </div>

</div>


</body>
</html>



