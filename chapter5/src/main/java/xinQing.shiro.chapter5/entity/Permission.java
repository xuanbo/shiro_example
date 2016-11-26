package xinQing.shiro.chapter5.entity;

/**
 * 权限
 * 角色跟权限多对多
 *
 * Created by xuan on 16-11-19.
 */
public class Permission {

    private Integer id;
    private String name;
    private Integer roleId;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleId=" + roleId +
                ", description='" + description + '\'' +
                '}';
    }
}
