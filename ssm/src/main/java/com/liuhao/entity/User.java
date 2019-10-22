package com.liuhao.entity;

import java.util.Date;

public class User {
    private Integer id;

    private String loginName;

    private String username;

    private String idcard;

    private String email;

    private String phone;

    private Date applicationTime;

    private Integer applicationDirection;

    private Integer checkStatus;

    private Integer state;

    private Date createTime;

    private Integer isdel;

    private String customerPower;

    private String password;

    private Integer role;

    private Integer createpeople;

    private String cteateName;//创建人名称
    
    private String category;

    private String area;

    private String starttime;

    private String endtime;

    private String company;

    private String address;

    private Integer msgflag;

    private String rName;//角色名称
    
    
    private User users;
    
    private Roles roles;
    
    private CropCategory cropCategory;
    
    private AddressProvince province;
    
    
    
	public CropCategory getCropCategory() {
		return cropCategory;
	}



	public void setCropCategory(CropCategory cropCategory) {
		this.cropCategory = cropCategory;
	}



	public AddressProvince getProvince() {
		return province;
	}



	public void setProvince(AddressProvince province) {
		this.province = province;
	}



	public User() {
		
	}
	
	
	
	public User(String loginName, String username, Integer state, String password, Integer role) {
		this.loginName = loginName;
		this.username = username;
		this.state = state;
		this.password = password;
		this.role = role;
	}



	public User(Integer id, String loginName, String username, Integer state, Date createTime, String rName,
			String cteateName) {
		this.id = id;
		this.loginName = loginName;
		this.username = username;
		this.state = state;
		this.createTime = createTime;
		this.rName = rName;
		this.cteateName = cteateName;
	}

	public User(Integer id, String loginName, String username, String idcard, String email, String phone,
			Date applicationTime, Integer applicationDirection, Integer checkStatus, Integer state, Date createTime,
			Integer isdel, String customerPower, String password, Integer role, Integer createpeople, String cteateName,
			String category, String area, String starttime, String endtime, String company, String address, Integer msgflag,
			String rName) {
		this.id = id;
		this.loginName = loginName;
		this.username = username;
		this.idcard = idcard;
		this.email = email;
		this.phone = phone;
		this.applicationTime = applicationTime;
		this.applicationDirection = applicationDirection;
		this.checkStatus = checkStatus;
		this.state = state;
		this.createTime = createTime;
		this.isdel = isdel;
		this.customerPower = customerPower;
		this.password = password;
		this.role = role;
		this.createpeople = createpeople;
		this.cteateName = cteateName;
		this.category = category;
		this.area = area;
		this.starttime = starttime;
		this.endtime = endtime;
		this.company = company;
		this.address = address;
		this.msgflag = msgflag;
		this.rName = rName;
	}

	
	
	public Roles getRoles() {
		return roles;
	}



	public void setRoles(Roles roles) {
		this.roles = roles;
	}



	public User getUsers() {
		return users;
	}
	public void setUsers(User users) {
		this.users = users;
	}



	public String getrName() {
		return rName;
	}

	public void setrName(String rName) {
		this.rName = rName;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCteateName() {
		return cteateName;
	}

	public void setCteateName(String cteateName) {
		this.cteateName = cteateName;
	}

	public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName ;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email ;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone ;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public Integer getApplicationDirection() {
        return applicationDirection;
    }

    public void setApplicationDirection(Integer applicationDirection) {
        this.applicationDirection = applicationDirection;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public String getCustomerPower() {
        return customerPower;
    }

    public void setCustomerPower(String customerPower) {
        this.customerPower = customerPower ;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password ;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getCreatepeople() {
        return createpeople;
    }

    public void setCreatepeople(Integer createpeople) {
        this.createpeople = createpeople;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category ;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area ;
    }

    

    public String getStarttime() {
		return starttime;
	}



	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}



	public String getEndtime() {
		return endtime;
	}



	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company ;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address ;
    }

    public Integer getMsgflag() {
        return msgflag;
    }

    public void setMsgflag(Integer msgflag) {
        this.msgflag = msgflag;
    }

	@Override
	public String toString() {
		return "User [id=" + id + ", loginName=" + loginName + ", username=" + username + ", idcard=" + idcard
				+ ", email=" + email + ", phone=" + phone + ", applicationTime=" + applicationTime
				+ ", applicationDirection=" + applicationDirection + ", checkStatus=" + checkStatus + ", state=" + state
				+ ", createTime=" + createTime + ", isdel=" + isdel + ", customerPower=" + customerPower + ", password="
				+ password + ", role=" + role + ", createpeople=" + createpeople + ", cteateName=" + cteateName
				+ ", category=" + category + ", area=" + area + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", company=" + company + ", address=" + address + ", msgflag=" + msgflag + ", rName=" + rName + "]";
	}
    
    
}