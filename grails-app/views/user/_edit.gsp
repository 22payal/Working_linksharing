<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
<div class="container">
    <div class="col-lg-6">
        <div class="col-lg-12">
            render userDEL template

        </div>
        <div class="col-lg-12">

            <div class=" panel panel-default  ">
                <div class="panel-heading " style="background:#1b1e21">
                    <div class="col-lg-4"style="margin-top: 0px">
                        <p style="margin-top: 0px">
                        <h3 style="color:white ;margin-top: 0px">Topic</h3></p>
                    </div>
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>

                </div>
                <div class="panel-body ">
                    <div class="col-lg-12">
                        <div class="col-lg-12 row">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-3 glyphicon glyphicon-user fa-5x">
                                    </div>

                                    <div class="col-sm-9">
                                        <form class="form-inline" action="/action_page.php">
                                            <div class="form-group">

                                                <input type="text" class="form-control" id="topic1" placeholder="topic name" name="topic1">
                                            </div>
                                            <button type="submit" class="btn btn-primary ">Save</button>
                                        </form>
                                        <br>

                                        <div class="row">
                                            <div class="col-sm-6">
                                                <h6 class="text-muted">@ajay</h6>
                                                <a href="#">Unsubscribe</a>
                                            </div>

                                            <div class="col-sm-3">
                                                <h6 class="text-muted pull-left">Subscriptions</h6>
                                                <h6 class="text-primary">5</h6>
                                            </div>

                                            <div class="col-sm-3">
                                                <h6 class="text-muted  pull-right">Post
                                                    <br>
                                                    <br>

                                                    <p class="text-primary">10</p>
                                                </h6>
                                            </div>
                                            <span type="img" class="fa fa-file pull-right fa-2x"
                                                  style="margin-left: 10px;  margin-right: 5px;"></span>
                                            <span type="img" class="fa fa-envelope pull-right fa-2x" style="margin-left: 10px;">
                                            </span>
                                            <span type="img" class="glyphicon glyphicon-trash pull-right fa-2x"
                                                  style="margin-left: 10px;">
                                            </span>

                                            <select class="pull-right   ">
                                                <option>Serious</option>
                                                <option>Casual</option>
                                                <option>Very Serious</option>
                                            </select>

                                            <div>
                                                <select class="pull-right ">
                                                    <option>Private</option>
                                                    <option>Public</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-12"><hr></div>


                </div>
            </div>


        </div>
    </div>
    <div class="col-lg-6">
        <div class="col-lg-12 " style="margin-top: 25px">

            <div class=" panel panel-default  ">
                <div class="panel-heading " style="background: #007efc">
                    <p>

                    <h3 style="color:white">Profile</h3></p>
                </div>

                <div class="panel-body ">
                    <g:form controller="#" action="#">
                        <div class="form-group col-lg-10">
                            <label for="fname">First Name</label>
                            <input class="form-control" type="text" name="fname" id="fname">
                        </div>
                        <div class="form-group col-lg-10">
                            <label for="lname">Last Name</label>
                            <input class="form-control" type="text" name="lname" id="lname">
                        </div>
                        <div class="form-group col-lg-10">
                            <label for="uname">UserName</label>
                            <input class="form-control" type="text" name="uname" id="uname">
                        </div>

                        <div class="col-lg-2"></div>

                        <div class="form-group col-lg-10">
                            <label for="photo">photo</label>
                            <input class="form-control" type="file" id="photo" name="photo">

                        </div>

                        <div class="col-lg-12"></div>

                        <div class="form-group col-lg-10">
                            <input type="submit" class="form-control btn-primary">
                        </div>

                    </g:form>


                </div>
            </div>
        </div>
        <div class="col-lg-12 " style="margin-top: 25px">

            <div class=" panel panel-default  ">
                <div class="panel-heading " style="background: #007efc">

                    <p>

                    <h3 style="color:white">Change Password</h3></p>
                </div>

                <div class="panel-body ">
                    <g:form controller="#" action="#">
                        <div class="form-group col-lg-10">
                            <label for="psw">Password*</label>
                            <input class="form-control" type="text" name="psw" id="psw">
                        </div>
                        <div class="form-group col-lg-10">
                            <label for="lname">Confirm Password*</label>
                            <input class="form-control" type="password" name="cpsw" id="cpsw">
                        </div>


                        <div class="col-lg-2"></div>



                        <div class="col-lg-12"></div>

                        <div class="form-group col-lg-10">
                            <input type="submit" class="form-control btn-primary">
                        </div>

                    </g:form>


                </div>
            </div>
        </div>

    </div>
</div>

</div>


</body>
</html>
