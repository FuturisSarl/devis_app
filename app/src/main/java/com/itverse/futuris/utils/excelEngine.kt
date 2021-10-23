package com.itverse.futuris.utils

import android.content.Context
import android.net.Uri
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.Materiel
import com.itverse.futuris.data.entities.Project
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFWorkbook

/**
 * Generates an excel file using data of project with id `projectID`
 * Return: true on success, false on failure
 */

fun generateExcelFileTest(
    context:Context,
    project: Project,
    composants: List<Composant>,
    groupedElements: ArrayList<List<GroupedElementsWithElements>>,
    materiel: List<Materiel>,
    uri: Uri
): Boolean {

    //TODO: put worksheet styling on a different function/module

    val workbook: Workbook = XSSFWorkbook()

    val sheet: Sheet = workbook.createSheet("Devis")

    val header: Row = sheet.createRow(0)

    val headerCell: Cell = header.createCell(0)
    headerCell.setCellValue("Materials")
    
    var rowIndex = 1
    var row: Row

    // Add project header
    row = sheet.createRow(rowIndex)
    rowIndex++
    row.createCell(0).setCellValue("Project: ")
    row.createCell(1).setCellValue(project.name)

    row = sheet.createRow(rowIndex)
    rowIndex++
    row.createCell(0).setCellValue("Materiels ")

    //Add Materials
    materiel.forEachIndexed{ i, m ->
        row = sheet.createRow(rowIndex)
        row.createCell(0).setCellValue(m.name)
        row.createCell(1).setCellValue(m.quantity.toDouble())
        rowIndex++
    }

    val outputStream = context.contentResolver.openOutputStream(uri)

    workbook.write(outputStream)
    workbook.close()

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