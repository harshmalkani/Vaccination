package Asha.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.google.appengine.api.images.ServingUrlOptions;

import Asha.entity.ChildInformationEntity;
import Asha.entity.UserRegistrationEntity;
import Asha.service.UserRegistrationService;

public class EditProfileController extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String name = request.getParameter("editname");
		String email = request.getParameter("editemail");
		String phone = request.getParameter("editphone");
		String password = request.getParameter("editpassword");
		
		email = email.trim();
		name = name.trim();
		
		HttpSession ses= request.getSession(false);
		UserRegistrationEntity ure = (UserRegistrationEntity) ses.getAttribute("parententity");
		ure.name = name;
		ure.email = email;
		ure.phone_number = phone;
		ure.password = password;
		ChildInformationEntity cie = (ChildInformationEntity) ses.getAttribute("childentity");
		cie.parent_email = email;
		
		
        BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		
		Map<String, List<BlobKey>> blobs = blobstoreService.getUploads(request);
		
		List<BlobKey> blobKeys = blobs.get("profilepic");
		
	if(blobKeys != null)
	{
		String blobKey = blobKeys.get(0).getKeyString();; 
		 

    	BlobKey bk = new BlobKey(blobKey); 
	    ImagesService imagesService = ImagesServiceFactory.getImagesService();
	    ServingUrlOptions servingOptions = ServingUrlOptions.Builder.withBlobKey(bk);
	    
	    String servingUrl = imagesService.getServingUrl(servingOptions);
		
	    ure.profile_pic = servingUrl;
	     
	    
	}
		
		UserRegistrationService urs = new UserRegistrationService();
		urs.saveChanges(ure);
		
		response.sendRedirect("/profilepage.jsp");
	
	
	}

}
