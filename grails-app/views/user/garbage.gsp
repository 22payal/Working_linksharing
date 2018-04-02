<%@ page import="enumeration.Visibility" %>
<div id="myModal" class="modal fade" role="dialog">
                  <div class="modal-dialog">

                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal">&times;</button>

                              <h4 class="modal-title">create topic</h4>

                              <div class="modal-body">

<g:form controller="topic" action="save" method="post">

    <div class="form-group">
        <label class="control-label col-sm-2" for="topicName">Topic Name</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="topicName"  name="topicName">
        </div>
    </div>

    <div class="dropdown">
        %{--<label>Visibility</label>--}%
        %{--<input class="form-control" id="newvisibility"  name="newvisibility" >--}%
        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" id="visibility">visibility
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            %{--<li><a href="#">private</a></li>--}%
            %{--<li><a href="#">public</a></li>--}%

            <li>  <g:select from="${Visibility}"  name="PRIVATE" value="PRIVATE "/></li>
            <li>   <g:select from="${Visibility}" name="PUBLIC" value="PUBLIC"/></li>


        </ul>

    </div>

</g:form>

<br>

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <g:actionSubmit name="save" value="save"  action="save" />
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

    </div>
</div>
</g:form>

</div>
<!--<div class="modal-footer">-->
<!--<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>-->
<!--</div>-->
</div>

</div>
</div>

