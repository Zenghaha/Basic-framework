package com.ud.basic.system.biz.service;

import com.ud.basic.common.model.PageData;
import com.ud.basic.system.controller.model.org.AddOrgRequest;
import com.ud.basic.system.controller.model.org.EditOrgRequest;
import com.ud.basic.system.controller.model.org.ListOrgRequest;
import com.ud.basic.system.controller.model.org.OrgAuthcEditRequest;
import com.ud.basic.system.controller.model.org.OrgAuthcMenuRequest;
import com.ud.basic.system.controller.model.org.SysOrgVO;
import com.ud.basic.system.controller.model.role.AuthcMenuVO;

public interface OrgService {

	PageData<SysOrgVO> ListOrgs(ListOrgRequest request);

	String addOrg(AddOrgRequest request);

	String editOrg(EditOrgRequest request);

	AuthcMenuVO authcMenu(OrgAuthcMenuRequest request);

	String authcEdit(OrgAuthcEditRequest request);

}
