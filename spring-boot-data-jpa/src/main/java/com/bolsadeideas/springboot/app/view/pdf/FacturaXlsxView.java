package com.bolsadeideas.springboot.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;

@Component("factura/ver.xlsx")
public class FacturaXlsxView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setHeader("content-Disposition", "attachment; filename=\"Factura_View.xlsx\"");
		Factura factura = (Factura)model.get("factura");
		Sheet sheet = workbook.createSheet("Factura Spring");
		
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		
		cell.setCellValue("Datos del Cliente");
		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue(factura.getCliente().getNombre()+ " "+factura.getCliente().getApellido());
		
		row = sheet.createRow(2);
		cell = row.createCell(0);
		cell.setCellValue(factura.getCliente().getEmail());
		// La 3 representa un espacio
		sheet.createRow(4).createCell(0).setCellValue("Datos de la Factura");
		sheet.createRow(5).createCell(0).setCellValue("Folio: "+factura.getId());
		sheet.createRow(6).createCell(0).setCellValue("Descripción: "+factura.getDescripcion());
		sheet.createRow(7).createCell(0).setCellValue("Fecha: "+factura.getCreateAt());
		
		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		CellStyle tbodyStyle = workbook.createCellStyle();
		tbodyStyle.setBorderBottom(BorderStyle.THIN);
		tbodyStyle.setBorderTop(BorderStyle.THIN);
		tbodyStyle.setBorderRight(BorderStyle.THIN);
		tbodyStyle.setBorderLeft(BorderStyle.THIN);
		
		// La 8 representa un espacio
		Row header = sheet.createRow(9);
		header.createCell(0).setCellValue("Producto");
		header.createCell(1).setCellValue("Precio");
		header.createCell(2).setCellValue("Cantidad");
		header.createCell(3).setCellValue("Total");
		
		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		int rowmum = 10;
		for(ItemFactura item: factura.getItems()) {
			
			Row fila = sheet.createRow(rowmum ++);
			cell = fila.createCell(0);
			cell.setCellValue(item.getProducto().getNombre());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(1);
			cell.setCellValue(item.getProducto().getPrecio().toString());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(2);
			cell.setCellValue(item.getCantidad().toString());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(3);
			cell.setCellValue(item.calcularImporte().toString());
			cell.setCellStyle(tbodyStyle);
		}
		
		
		
		Row filaTotal = sheet.createRow(rowmum);
		filaTotal.createCell(2).setCellValue("Gran Total: ");
		filaTotal.createCell(3).setCellValue(factura.getTotal());
		
		cell = filaTotal.createCell(3);
		cell.setCellValue(factura.getTotal());
		cell.setCellStyle(tbodyStyle);
		
		
		
		
		
		
		
	}
	
}
