SESSION 7 - MINI PROJECT: PlaylistManager

Technology:
- Spring MVC
- Java 17
- JSP
- Maven
- Tomcat 9
- No database (data stored in Java List)

Run:
1. Import this folder as Existing Maven Project in Eclipse/STS.
2. Maven > Update Project.
3. Add Apache Tomcat 9 server.
4. Run project on server.
5. Open:
   http://localhost:8080/PlaylistManager/

Features:
1. View playlist list
2. Add playlist using JSP form
3. View single playlist details using /playlist/{id}
4. Redirect to list after adding playlist

Main controller:
com.playlist.controller.PlaylistController

JSP files:
WEB-INF/views/playlist-list.jsp
WEB-INF/views/add-playlist.jsp
WEB-INF/views/playlist-details.jsp
