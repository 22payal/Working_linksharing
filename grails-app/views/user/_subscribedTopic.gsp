<%@ page import="linksharing.Subscription" %>
<%@ page import="linksharing.Topic" %>


<div class="panel-body">
    <div class="row">
        <div class="col-sm-12">
            <g:each in="${Subscription.getSubscribedTopics(session.user)}" var="subscribedTopics" >
            <div class="row" >

                <div class="col-sm-3 fa fa-user fa-5x">

               %{--<div class="col-sm-2">--}%
               %{--<ls:userImage username="${subscribedTopics.createdBy}" height="50" width="50"/>--}%
               %{--</div>--}%

           </div>

                <div class="col-sm-9" id="deleteMe">

                        <a href="#" class="pull-left">${subscribedTopics.topicName}</a>
                        <br>

                        <div class="row">
                            <div class="col-sm-6">
                                <h6 class="text-muted">${session.user.userName}</h6>

                                %{--<g:link controller="subscription" action="subscriptionDelete"--}%
                                        %{--id="${subscribedTopics}">Unsubscribe</g:link>--}%

                                <button class="unsubscribeMe pull-right" id="${subscribedTopics.id}" onclick="deleteEntry(this.id);">Unsubscribe</button>


                            </div>

                            <div class="col-sm-2">
                                <h6 class="text-muted pull-left">Subscriptions</h6>
                                <h6 class="text-primary">
                                    <ls:subscriptionCount id="${subscribedTopics}"> </ls:subscriptionCount>
                                </h6>
                            </div>

                            <div class="col-sm-3">
                                <h6 class="text-muted  pull-right">Post
                                    <br>
                                    <br>
                                    <p class="text-primary">
                                        <ls:resourceCount id="${subscribedTopics}"> </ls:resourceCount>
                                    </p>
                                </h6>
                            </div>

                            <li class="col-lg-1" style="padding: 0px">

                                <a href="#myModal2" data-toggle="modal"
                                                                         data-target="#myModal2"><i class="fa fa-envelope"
                                                                                                    style="font-size:24px"></i></a>
                            </li>

                            <div id="updateMe" class="pull-right">
                            <g:select name="seriousness" from="${enumeration.Seriousness.values()}" value="seriousness" id="${subscribedTopics.id}" onchange="categoryChanged(this.value);" />

                            </div>

                        </div>
                </div>
            </div>
                    </g:each>

        </div>
    </div>
</div>

<script>
    // function categoryChanged(categoryId) {
    //     jQuery.ajax({type:'POST',data:'categoryId='+categoryId  ,url:'/subscription/updateSeriousness/categoryChanged',success:function(data,textStatus){jQuery('#updateMe').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});
    // }

    function deleteEntry(topicId) {
        jQuery.ajax({type:'POST',data:'topicId='+topicId  ,url:'/subscription/subscriptionDelete/deleteEntry',success:function(data,textStatus){jQuery('#deleteMe').html(data);},error:function(XMLHttpRequest,textStatus,errorThrown){}});
    }
</script>