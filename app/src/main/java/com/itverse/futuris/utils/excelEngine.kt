package com.itverse.futuris.utils

import android.content.Context
import android.util.Log
import com.itverse.futuris.data.entities.Composant
import com.itverse.futuris.data.entities.Materiel
import com.itverse.futuris.data.entities.Project
import com.itverse.futuris.data.entities.relations.GroupedElementsWithElements
import com.itverse.futuris.mViewModels.ComposantViewModel
import com.itverse.futuris.mViewModels.GroupedElementsViewModel
import com.itverse.futuris.mViewModels.MaterielViewModel
import com.itverse.futuris.mViewModels.ProjectViewModel
import kotlinx.coroutines.flow.*
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFFont

import org.apache.poi.xssf.usermodel.XSSFWorkbook


/**
 * Generates an excel file using data of project with id `projectID`
 * Return: true on success, false on failure
 */

suspend fun generateExcelFileTest(
    context:Context,
    project: Project,
    composants: List<Composant>,
    groupedElements: ArrayList<List<GroupedElementsWithElements>>,
    materiel: List<Materiel>
): Boolean {

    //TODO: put worksheet styling on a different function/module

    //var materiels = materielViewModel.allMaterielsFrom(project.id)
    //Log.i("export", "Materiels: $materiels")

    // TODO: Loop over grouped elements
    //      If composant is materiel, fetch material and add on the spreadsheet
    //      IF composant is a grouped element, fatch it and save on spreadsheet

    //var materiels = materielViewModel.allMaterielsFrom(composantId)

    //var elements = groupedElementsViewModel.allGroupedElementsFrom(composantId)
    /*
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