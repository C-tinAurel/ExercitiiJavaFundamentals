package business.service.product;

import business.dto.DepartmentDTO;
import business.dto.DepositDTO;
import business.dto.product.PaintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import persistence.dao.DepartmentDAO;
import persistence.dao.product.PaintDAO;
import persistence.entities.Department;
import persistence.entities.Deposit;
import persistence.entities.product.Paint;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PaintService {

    @Autowired
    PaintDAO paintDAO;
    @Autowired
    DepartmentDAO departmentDAO;

    public void insertPaint(PaintDTO paintDTO) {
        Paint paint = new Paint();
        paint.setName(paintDTO.getName());
        paint.setMark(paintDTO.getMark());
        paint.setColor(paintDTO.getColor());
        paint.setPrice(paintDTO.getPrice());
        paint.setStock(paintDTO.getStock());
        Set<Deposit> depositSet = new HashSet<>();
        for (DepositDTO depositDTO : paintDTO.getDepositDTOSet()) {
            Deposit deposit = new Deposit();
            deposit.setCity(depositDTO.getCity());
            deposit.setAddress(depositDTO.getAddress());
            depositSet.add(deposit);
        }
        setDepartment(paintDTO, paint);
        paint.setDepositSet(depositSet);
        paintDAO.insert(paint);
    }
    public  void setDepartment(PaintDTO paintDTO,Paint paint){
        Department departmentPaint=null;
        departmentPaint=departmentDAO.findDepartmentByName(paintDTO.getDepartmentDTO().getName());
        if(departmentPaint==null){
            departmentPaint=new Department();
            departmentPaint.setName(paintDTO.getDepartmentDTO().getName());
        }
        paint.setDepartment(departmentPaint);
    }

    public List<PaintDTO> findPaintByColor(String color) {
        List<Paint> paintList = paintDAO.findPaintByColor(color);
        List<PaintDTO> paintDTOList = new ArrayList<>();
        for (Paint paint : paintList) {
            PaintDTO paintDTO = new PaintDTO();
            paintDTO.setName(paint.getName());
            paintDTO.setMark(paint.getMark());
            paintDTO.setColor(paint.getColor());
            paintDTO.setPrice(paint.getPrice());
            paintDTO.setStock(paint.getStock());
            DepartmentDTO departmentDTO = new DepartmentDTO();
            departmentDTO.setName(paint.getDepartment().getName());
            paintDTO.setDepartmentDTO(departmentDTO);
            Set<DepositDTO> depositDTOSet = new HashSet<>();
            for (Deposit deposit : paint.getDepositSet()) {
                DepositDTO depositDTO = new DepositDTO();
                depositDTO.setCity(deposit.getCity());
                depositDTO.setAddress(deposit.getAddress());
                depositDTOSet.add(depositDTO);
            }
            paintDTO.setDepositDTOSet(depositDTOSet);
            paintDTOList.add(paintDTO);
        }
        return paintDTOList;
    }
    public Integer deletePaintColor(String color){
        Integer deletedPaintColor =paintDAO.deletePaintColor(color);
        return deletedPaintColor;
    }
    public Integer updatedPaintMark(String mark,String name){
        Integer updatedPaint=paintDAO.updatePaintMark(mark, name);
        return updatedPaint;
    }
}
