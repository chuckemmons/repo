<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="clearfix">
<div class="container">
  <div class="row">
    <div class="col-md-12">
      <div class="well well-sm">
        <form:form class="form-horizontal" method="post" action="contact" modelAttribute="contact">
          <fieldset>
            <legend class="text-center header">Contact me</legend>
            
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
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
              <div class="col-md-8">
                <form:input type="text" path="email" placeholder="Email Address" class="form-control" />
                <div class="has-error">
                  <form:errors path="email" class="input-help"/>
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
            
            <span class="no-display">
              <form:input type="text" path="url" />
            </span>
            
            <div class="form-group">
              <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-pencil-square-o bigicon"></i></span>
              <div class="col-md-8">
                <form:textarea path="message" placeholder="What's on your mind? I'll get back to you as soon as I can." rows="7" class="form-control" ></form:textarea>
                <div class="has-error">
                  <form:errors path="message" class="input-help"/>
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