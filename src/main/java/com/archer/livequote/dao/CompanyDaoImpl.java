package com.archer.livequote.dao;

import com.archer.livequote.util.CommonUtils;
import com.archer.livequote.db.domain.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

@Repository
public class CompanyDaoImpl implements CompanyDao {

    @Autowired
    public CrudDao crud;

    //get..
    @Override
    public CompanyEntity getByGuid(String guid) {
        return crud.getByField("guid", guid, CompanyEntity.class);
    }


    @Override
    public CompanyEntity getByEmail(String email) {
        return crud.getByField("email_list", email, CompanyEntity.class);
    }

    @Override
    public List<CompanyEntity> getByCaegoryAndArea(String category, String area) {
        String query = "{ $and: [ { categories: '" + category + "' }, { area:'" + area + "'  }] }";
        return crud.getByQueryString(query, CompanyEntity.class);
    }


    @Override
    public CompanyEntity insertNewCompany(CompanyEntity newCompany) {
        String time = CommonUtils.getCurrentTime();
        newCompany.setGuid(CommonUtils.generateUid());
        newCompany.setAddDate(time);
        newCompany.setModDate(time);
        return crud.save(newCompany);
    }

    // @Override
    // public CompanyEntity updateCompanyName(String guid, String newName) {
    // String time = CommonUtils.getCurrentTime();
    // CompanyEntity comp = getByGuid(guid);
    // comp.setCompanyName(newName);
    // comp.setModDate(time);
    // return crud.save(comp);
    // }
    // update all non-list field for company entity..
    @Override
    public CompanyEntity updateComapnyInfo(String guid, CompanyEntity newComp) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        if (newComp.getAccountType() != null)
            comp.setAccountType(newComp.getAccountType());
        if (newComp.getCompanyName() != null)
            comp.setCompanyName(newComp.getCompanyName());
        if (newComp.getExpireDate() != null)
            comp.setExpireDate(newComp.getExpireDate());
        if (newComp.getPhone() != null)
            comp.setPhone(newComp.getPhone());
        if (newComp.getPassword() != null){
            comp.setPassword(newComp.getPassword());}
        if (newComp.getUserName() != null)
            comp.setUserName(newComp.getUserName());
        if (newComp.getStatus() != null)
            comp.setStatus(newComp.getStatus());
        comp.setModDate(time);
        return crud.save(comp);
    }

    // email operation..
    @Override
    public CompanyEntity updateCompanyEmail(String guid, String oldEmail,
                                            String newEmail) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        List<String> emails = comp.getEmail();
        for (String email : emails) {
            if (email.equalsIgnoreCase(oldEmail)) {
                emails.set(emails.indexOf(oldEmail), newEmail);
            }
        }
        comp.setModDate(time);
        return crud.save(comp);
    }

    @Override
    public CompanyEntity addCompanyEmail(String guid, String newEmail) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        if (!comp.getEmail().contains(newEmail)) {
            comp.getEmail().add(newEmail);
            comp.setModDate(time);
            return crud.save(comp);
        }
        return null;
    }

    @Override
    public CompanyEntity removeEmail(String guid, String emailToRemove) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        List<String> emails = comp.getEmail();

        Iterator<String> it = emails.iterator();
        while (it.hasNext()) {
            String email = it.next();
            if (email.equalsIgnoreCase(emailToRemove)) {
                it.remove();
            }
        }
        comp.setModDate(time);
        return crud.save(comp);
    }

    // category operation...

    @Override
    public CompanyEntity addCategory(String guid, String newCategory) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        if (!comp.getCategory().contains(newCategory)) {
            comp.getCategory().add(newCategory);
            comp.setModDate(time);
            return crud.save(comp);
        }
        return null;
    }

    @Override
    public CompanyEntity removeCategory(String guid, String categoryToRemove) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        List<String> cateList = comp.getCategory();

        Iterator<String> it = cateList.iterator();
        while (it.hasNext()) {
            String cate = it.next();
            if (cate.equalsIgnoreCase(categoryToRemove)) {
                it.remove();
            }
        }
        comp.setModDate(time);
        return crud.save(comp);
    }

    //area operation...
    @Override
    public CompanyEntity addArea(String guid, String newArea) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        if (!comp.getArea().contains(newArea)) {
            comp.getArea().add(newArea);
            comp.setModDate(time);
            return crud.save(comp);
        }
        return null;
    }

    @Override
    public CompanyEntity removeArea(String guid, String areaToRemove) {
        String time = CommonUtils.getCurrentTime();
        CompanyEntity comp = getByGuid(guid);
        List<String> areaList = comp.getArea();
        Iterator<String> it = areaList.iterator();
        while (it.hasNext()) {
            String area = it.next();
            if (area.equalsIgnoreCase(areaToRemove)) {
                it.remove();
            }
        }
        comp.setModDate(time);
        return crud.save(comp);
    }

    // @Override
    // public CompanyEntity addCategoryForCompany(String guid, String category)
    // {
    // String time = CommonUtils.getCurrentTime();
    // CompanyEntity comp = getByGuid(guid);
    // comp.getCategory().add(category);
    // comp.setModDate(time);
    // return crud.save(comp);
    // }

    // @Override
    // public CompanyEntity removeCategory(String guid, String category) {
    // String time = CommonUtils.getCurrentTime();
    // CompanyEntity comp = getByGuid(guid);
    // List<String> cateList = comp.getCategory();
    // for (String cate : cateList) {
    // if (cate.equalsIgnoreCase(category)) {
    // cateList.remove(category);
    // }
    // }
    // comp.setModDate(time);
    // return crud.save(comp);
    // }

    @Override
    public boolean removeCompany(String guid) {
        return crud.remove("guid", guid, CompanyEntity.class) != null;
    }

//    @Override
//    public CompanyEntity updatePassword(String guid, String newPassword) {
//        String time = CommonUtils.getCurrentTime();
//        CompanyEntity comp = getByGuid(guid);
//        comp.setPassword(newPassword);
//        comp.setModDate(time);
//        return crud.save(comp);
//    }

}
