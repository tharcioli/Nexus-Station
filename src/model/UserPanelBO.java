package model;

public class UserPanelBO {

    private UserPanelDAO userPanelDAO;

    public UserPanelBO() {
    	
        userPanelDAO = new UserPanelDAO();
    }

    public String getEmail(String userID) {
    	
        return userPanelDAO.getUserEmail(userID);
    }

    public String getPassword(String userID) {
    	
        return userPanelDAO.getUserPassword(userID);
    }

    public String getAcessWork(String userID) {
    	
        return userPanelDAO.getUserAcessWork(userID);
    }

    public String getTip(String userID) {
    	
        return userPanelDAO.getUserTip(userID);
    }

    public boolean deleteUser(String userID) {
    	
        return userPanelDAO.deleteUser(userID);
    }

    public boolean updateUserID(String userID, String newUserID) {
    	
        return userPanelDAO.updateUserID(userID, newUserID);
    }

    public boolean canUpdateUserID(String userID, String newUserID) {
    	
        return userPanelDAO.canUpdateUserID(userID, newUserID);
    }

    public boolean updateEmail(String userID, String newEmail) {
    	
        return userPanelDAO.updateEmail(userID, newEmail);
    }

    public boolean canUpdateEmail(String userID, String newEmail) {
    	
        return userPanelDAO.canUpdateEmail(userID, newEmail);
    }

    public boolean updatePassword(String userID, String newPassword) {
    	
        return userPanelDAO.updatePassword(userID, newPassword);
    }

    public boolean updateAcessWork(String userID, String newAcessWork) {
    	
        return userPanelDAO.updateAcessWork(userID, newAcessWork);
    }

    public boolean updateTip(String userID, String newTip) {
    	
        return userPanelDAO.updateTip(userID, newTip);
    }
}
