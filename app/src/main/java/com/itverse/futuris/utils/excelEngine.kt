package com.itverse.futuris.utils

import android.content.Context
import android.os.Environment
import android.widget.Toast
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFFont

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Cell

import org.apache.poi.ss.usermodel.CellStyle
import java.io.File
import java.io.FileOutputStream


/**
 * Generates an excel file using data of project with id `projectID`
 * Return: true on success, false on failure
 */

fun generateExcelFileTest(context:Context, projectId: Int): Boolean {

    //TODO: put worksheet styling on a different function/module

    /*val project = DataManager.projects[projectId]
    val timestamp = System.currentTimeMillis()

    val workbook: Workbook = XSSFWorkbook()

    val sheet: Sheet = workbook.createSheet("Devis")

    val header: Row = sheet.createRow(0)

    var headerCell: Cell = header.createCell(0)
    headerCell.setCellValue("Materials")
    
    var rowIndex = 1
    var name: Cell
    var value: Cell
    var row: Row 
    project.composants.forEachIndexed { index, composant ->

        if(composant.groupedElements != null){
            composant.groupedElements!!.forEach {
                row = sheet.createRow(rowIndex)
                name = row.createCell(0)
                name.setCellValue(it.name)
                rowIndex++
                it.elements.forEach{ element ->
                    row = sheet.createRow(rowIndex)
                    name = row.createCell(0)
                    name.setCellValue(element.name)

                    value = row.createCell(1)
                    value.setCellValue(element.value.toString())
                    rowIndex++
                }
            }
        }
        else if(composant.materials != null){
            composant.materials!!.forEach{
                row = sheet.createRow(rowIndex)
                name = row.createCell(0)
                name.setCellValue(it.name)
                
                value = row.createCell(1)
                value.setCellValue(it.number.toString())
                rowIndex++
            }
        }
    }

    val path: File? = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
    val file = File(path, "Devis-${project.name}-${timestamp}.xlsx")

    val outputStream = FileOutputStream(file)
    workbook.write(outputStream)
    workbook.close()


     */
    return true
}


fun styleWorksheet(workbook: Workbook){
    val headerStyle = workbook.createCellStyle()
    headerStyle.fillForegroundColor = IndexedColors.LIGHT_BLUE.getIndex()
    headerStyle.fillPattern = FillPatternType.SOLID_FOREGROUND

    val font: XSSFFont = (workbook as XSSFWorkbook).createFont()
    font.fontName = "Arial"
    font.fontHeightInPoints = 16.toShort()
    font.bold = true
    headerStyle.setFont(font)
}