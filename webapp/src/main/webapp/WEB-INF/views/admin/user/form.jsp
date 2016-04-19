<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="clearfix">
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div class="well well-sm">
        <form:form class="form-horizontal" method="post" action='<spring:url value="/admin/user/submit" htmlEscape="true"/>' modelAttribute="user">
          <fieldset>
            <legend class="text-center header">User</legend>
            
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="email" placeholder="Email Address" class="form-control" />
                <div class="has-error">
                  <form:errors path="email" class="input-help"/>
                </div>
              </div>
            </div>
            
            <!-- Enter password here -->
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="firstName" placeholder="First Name" class="form-control" />
                <div class="has-error">
                  <form:errors path="firstName" class="input-help"/>
                </div>
              </div>            
            </div>
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="lastName" placeholder="Last Name" class="form-control" />
                <div class="has-error">
                  <form:errors path="lastName" class="input-help"/>
                </div>
              </div>
            </div>
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-phone-square bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="phone" placeholder="Phone" class="form-control" />
                <div class="has-error">
                  <form:errors path="phone" class="input-help"/>
                </div>
              </div>
            </div>
                        
            <div class="form-group">
              <div class="col-md-12 text-center">
                <button type="submit" class="btn btn-primary btn-lg">Send</button>
              </div>
            </div>
            
          </fieldset>
        </form:form>
      </div>
    </div>
  </div>
</div>
</div>