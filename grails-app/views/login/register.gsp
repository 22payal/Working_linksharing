<%@ page import="linksharing.Resource" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <title></title>
    <meta name="layout" content="main">

</head>

<body>

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
                        <g:render template="/Resource/recentShares"></g:render>
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
                            <g:render template="/topic/topPost"></g:render>
                        </div>
                    </div>

                </div>
            </div>

        </div>

    </div>

    <div class="col-lg-6">

        <div class="panel-body ">

         <g:render template="userLogin"></g:render>


        </div>



        <div class="panel-body ">
            <g:render template="userRegister"></g:render>
        </div>
    </div>

    </div>

</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>