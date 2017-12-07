<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 
<%--  <link href='<core:url value="/resources/css/animate.css"/>' rel="stylesheet"> --%>
 <link rel="stylesheet" href='<core:url value="/resources/css/bootstrap.min.css"/>'>
 <link rel="stylesheet" href='<core:url value='/resources/css/adminmenu.css'/>'>

 <script src='<core:url value="/resources/js/jquery.js"/>'></script>
  <script src='<core:url value="/resources/js/bootstrap.min.js"/>'></script>
 <script src='<core:url value="/resources/js/adminmenu.js"/>'></script>
 <script src='<core:url value="/resources/js/boottable.js"/>'></script>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
 <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">

<body class="home">

    <div class="container-fluid display-table" >
        <div class="row display-table-row">
            <div class="col-md-2 col-sm-1 hidden-xs display-table-cell v-align box" id="navigation">
               
                <div class="navi">
                    <ul>
                        <li class="active"><a href="getEditDoctorPage"><i class="fa fa-stethoscope" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Doctor</span></a></li>
                        <li><a href="getEditStaffPage"><i class="fa fa-tasks" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Staff</span></a></li>
                        <li><a href="getEditLabPage"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Lab</span></a></li>
                        <li><a href="getEditPharmaPage"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Pharma</span></a></li>
                        </ul>
                </div>
            </div>
            <div class="col-md-10 col-sm-11 display-table-cell v-align">
                <!--<button type="button" class="slide-toggle">Slide Toggle</button> -->
                <div class="row">
                        </div>
                <div class="user-dashboard">
                   
                    <div class="row">
                       <!--  <div class="col-md-5 col-sm-5 col-xs-12 gutter">

                            <div class="sales">
                                <h2>Your Sale</h2>

                                </div>
                        </div> -->
                        
                        
                        <div class="container">
					<div class="row">
		
        
        <div class="col-md-10">
        <h4>Doctor Details</h4>
        <div class="table-responsive">

              <div>
					<form action="${pageContext.request.contextPath}/searchDoctor?searchValue">
					<input type="text" name="searchValue"></input><span id="sid"></span><input type="submit" value="search"/>
					</form>
				</div>
                
              <table id="list_doctor" class="table table-bordred table-striped">
                   
                   <thead>
                   <tr>
                   <th><input type="checkbox" id="checkall" /></th>
                    <th>SNO</th>
                  	<th>Doctor Name</th>
                    <th>Email</th>
                     <th>Gender</th>
                     <th>action</th></tr>
                   </thead>
    		<tbody>
    <core:set var="absKey" value="${doctorBean.getDocId()}" scope="session" />
    <%-- <core:out value="${docbean.getDocId()}"/> --%>
   <%--  <tr><td>${absKey}</td>
				<td>${doctorBean.getDocName()}</td></tr> --%>
				<core:choose>
				<core:when test="${not empty DoctorList}">
				
				<core:forEach varStatus="loop" items="${DoctorList}" var="docbean">
				<core:set var="absKey" value="${docbean.getDocId()}" scope="session" />
				
				<tr>
				 <th><input type="checkbox" id="checkall" /></th>
				<td>${loop.index+1}</td>
				<td>${docbean.getDocName()}</td>
				<td>${docbean.getEmail()}</td>
				<td>${docbean.getGender()}</td>

				 <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button  onclick="deleteUser('${absKey}');" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
				 <td><p data-placement="top" data-toggle="tooltip" title="Edit"><a href="${pageContext.request.contextPath}/getDoctorById?docId=${docbean.getDocId()}" type="button" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></a></p></td>
   				
				</tr>
				</core:forEach>
				</core:when>
				</core:choose>
				
				<core:choose>
				<core:when test="${not empty docBean}">
				<core:set  value="${docBean}" var="docBean"></core:set>
				<core:set var="absKey" value="${docBean.getDocId()}" scope="session" />
				<tr>
				<th><input type="checkbox" id="checkall" /></th>
				<td>1</td>
				<td>${docBean.getDocName()}</td>
				<td>${docBean.getEmail()}</td>
				<td>${docBean.getGender()}</td>

				  <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button  onclick="deleteUser('${absKey}');" class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><span class="glyphicon glyphicon-trash"></span></button></p></td>
				 <td><p data-placement="top" data-toggle="tooltip" title="Edit"><a href="${pageContext.request.contextPath}/getDoctorById?docId=${docbean.getDocId()}" type="button" class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><span class="glyphicon glyphicon-pencil"></span></a></p></td>
				</tr>
				</core:when>
				</core:choose>				
    		</tbody>
        
</table>
<div><a href="addDoctor">Add Doctor</a></div>
<div class="clearfix"></div>
<ul class="pagination pull-right">
  <li class="disabled"><a href="#"><span class="glyphicon glyphicon-chevron-left"></span></a></li>
  <li class="active"><a href="#">1</a></li>
  <li><a href="#">2</a></li>
  <li><a href="#">3</a></li>
  <li><a href="#">4</a></li>
  <li><a href="#">5</a></li>
  <li><a href="#"><span class="glyphicon glyphicon-chevron-right"></span></a></li>
</ul>
            </div>  
        </div>
	</div>
</div>

<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
   <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Edit Doctor Detail</h4>
      </div>
     
    <%--  <form:form action="updateDoctor">
          <div class="modal-body">
          
          <div class="form-group">
        <label>DocId:</label>
        <input class="form-control " type="text" name="DocId" value="${sessionScope.doctorBean.getDocId()}">
        </div>
        <label>DoctorName:</label>
        <div class="form-group">
        <input class="form-control " type="text" name="DocName" value="${sessionScope.doctorBean.getDocName()}">
        </div>
        <label>Gender:</label>
         <div class="form-group">
        <input class="form-control " type="text" name="Gender" value="${sessionScope.doctorBean.getGender()}">
        </div>
         <label>Email:</label>
         <div class="form-group">
        <input class="form-control" type="text" name="Email" value="${sessionScope.doctorBean.getEmail()}">
        </div>
        <!-- <div class="form-group">
        <input class="form-control " type="button" value="update">
        </div>
        <div class="form-group">
        <input class="form-control " type="button" value="cancel">
        </div> -->
        <!-- <div class="form-group">
        <textarea rows="2" class="form-control" placeholder="CB 106/107 Street # 11"></textarea>
    
        
        </div> -->
        
      </div>
          <div class="modal-footer ">
        <button type="submit" class="btn btn-warning btn-lg" style="width: 100%;"><span class="glyphicon glyphicon-ok-sign"></span> Update</button>
      </div>
       </form:form> --%>
      </div> 
       
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
  </div>
    
    
    
    <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="delete" aria-hidden="true">
      <div class="modal-dialog">
    <div class="modal-content">
          <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
        <h4 class="modal-title custom_align" id="Heading">Delete this entry</h4>
      </div>
          <div class="modal-body">
       
       <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span> Are you sure you want to delete this Record?</div>
       <input type="hidden" id="userId" name="tempId"/>	
       
      </div>
        <div class="modal-footer ">
        <%-- <a href="deleteDoctorById?docId=<core:out value="${abs}"/>"><button id="btnYes" type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button></a> --%>
       <button id="deleteUserYes" type="button" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Yes</button>
        <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> No</button>
      </div>
        </div>
    <!-- /.modal-content --> 
  </div>
      <!-- /.modal-dialog --> 
    </div>
                       <!--  <div class="col-md-7 col-sm-7 col-xs-12 gutter">

                            <div class="sales report">
                                <h2>Report</h2>
                                
                            </div> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>




    <!-- Modal -->
    <div id="add_project" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header login-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Add Project</h4>
                </div>
                <div class="modal-body">
                            <input type="text" placeholder="Project Title" name="name">
                            <input type="text" placeholder="Post of Post" name="mail">
                            <input type="text" placeholder="Author" name="passsword">
                            <textarea placeholder="Desicrption"></textarea>
                    </div>
                <div class="modal-footer">
                    <button type="button" class="cancel" data-dismiss="modal">Close</button>
                    <button type="button" class="add-project" data-dismiss="modal">Save</button>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript">

function deleteUser(userId){
	alert("userid"+userId);
	jQuery("#userId").val(userId);
	
	console.log(jQuery("#userId").val());
	alert("hai  "+jQuery("#userId").val());
}

var appl_url='${pageContext.request.contextPath}';
jQuery("#deleteUserYes").on('click', function() {
	var docId = jQuery("#userId").val();
	jQuery.ajax({
		cache : false,
		type : "POST",
		datatype:'json',
		data : {
			"docId" : docId
		},
		url : appl_url + "/deleteDoctorById",
		success : function(result) {
			alert("result "+result);
			 window.location=appl_url+"/getEditDoctorPage"; 
				}
	});
});
/* function updateUser(userId){
	alert("userid   "+userId);
	jQuery("#userId").val(userId);
	
	console.log(jQuery("#userId").val());
	//alert("hai  "+jQuery("#userId").val(userId));
}
jQuery("#updateUserYes").on('click', function() {
	var docId = jQuery("#userId").val();
	jQuery.ajax({
		cache : false,
		type : "POST",
		datatype:'json',
		data : {
			"docId" : docId
		},
		url : appl_url + "/deleteDoctorById",
		success : function(result) {
			//alert("result "+result);
			 window.location=appl_url+"/getEditDoctorPage"; 
				}
	});
});
 */
</script>
</body>
</html>