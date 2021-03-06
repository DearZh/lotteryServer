package admin.domains.content.vo;

public class AdminUserBaseVO
{
  private int id;
  private String username;
  
  public AdminUserBaseVO() {}
  
  public AdminUserBaseVO(int id, String username)
  {
    this.id = id;
    this.username = username;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getUsername()
  {
    return this.username;
  }
  
  public void setUsername(String username)
  {
    this.username = username;
  }
}
