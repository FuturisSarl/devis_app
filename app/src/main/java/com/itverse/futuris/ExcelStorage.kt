package com.itverse.futuris

import android.content.Context
import android.os.Environment
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFFont

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.Cell

import org.apache.poi.ss.usermodel.CellStyle
import java.io.File
import java.io.FileOutputStream


fun generateExcelFileTest(context:Context) {

    val workbook: Workbook = XSSFWorkbook()

    val sheet: Sheet = workbook.createSheet("Persons")
    sheet.setColumnWidth(0, 6000)
    sheet.setColumnWidth(1, 4000)

    val header: Row = sheet.createRow(0)

    val headerStyle = workbook.createCellStyle()
    headerStyle.fillForegroundColor = IndexedColors.LIGHT_BLUE.getIndex()
    //headerStyle.fillPattern = FillPatternType.SOLID_FOREGROUND

    val font: XSSFFont = (workbook as XSSFWorkbook).createFont()
    font.fontName = "Arial"
    font.fontHeightInPoints = 16.toShort()
    font.bold = true
    headerStyle.setFont(font)

    var headerCell: Cell = header.createCell(0)
    headerCell.setCellValue("Name")
    headerCell.cellStyle = headerStyle

    headerCell = header.createCell(1)
    headerCell.setCellValue("Age")
    headerCell.cellStyle = headerStyle

    val style = workbook.createCellStyle()
    style.wrapText = true

    val row = sheet.createRow(2)
    var cell = row.createCell(0)
    cell.setCellValue("John Smith")
    cell.cellStyle = style

    cell = row.createCell(1)
    cell.setCellValue(20.0)
    cell.cellStyle = style

    //val path = context.externalCacheDir!!.absolutePath
    //val fileLocation = path.substring(0, path.length - 1) + "testSpreadsheet.xlsx"

    val path: File? = context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS)
    val file = File(path, "export.xlsx")

    //val outputStream = FileOutputStream(context.getExternalFilesDirs(null) + fileLocation)
    val outputStream = FileOutputStream(file)
    workbook.write(outputStream)
    workbook.close()
    println(path)
}