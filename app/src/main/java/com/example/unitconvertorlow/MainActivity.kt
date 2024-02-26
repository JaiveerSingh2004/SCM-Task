package com.example.unitconvertor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconvertorlow.ui.theme.UnitConvertorLowTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConvertorLowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConvertor()
                }
            }
        }
    }
}

@Composable
fun UnitConvertor() {
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeter") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    var conversionFactor = remember { mutableStateOf(0.01) }
    var oConversionFactor = remember { mutableStateOf(0.01) }
    var inputName by remember { mutableStateOf("Select") }
    var outputName by remember { mutableStateOf("Select") }

    fun convertUnits()
    {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.value * 100 / oConversionFactor.value).roundToInt() / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Unit Convertor")
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = inputValue,
            onValueChange = {
                inputValue = it
            },
            label = { Text(text = "Enter Value") })
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Box {
                Button(onClick = { iExpanded = true })
                {

                    Text(text = inputName)
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = "Arrow Down"
                    )

                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false })
                {
                    DropdownMenuItem(text = { Text("Millimeter") },
                        onClick = {
                            inputUnit = "Millimeter"
                            iExpanded = false
                            conversionFactor.value = 0.01
                            inputName = "Millimeter"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Centimeter") },
                        onClick = {
                            inputUnit = "Centimeter"
                            iExpanded = false
                            conversionFactor.value = 0.1
                            inputName = "Centimeter"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Inches") },
                        onClick = {
                            inputUnit = "Inches"
                            iExpanded = false
                            conversionFactor.value = 0.025
                            inputName = "Inches"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Meter") },
                        onClick = {
                            inputUnit = "Meter"
                            iExpanded = false
                            conversionFactor.value = 1.0
                            inputName = "Meter"
                            convertUnits()
                        })
                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                            conversionFactor.value = 0.304
                            inputName = "Feet"
                            convertUnits()
                        })

                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Box {
                Button(onClick = { oExpanded = true })
                {
                    Text(text = outputName)
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false })
                {
                    DropdownMenuItem(text = { Text("Millimeter") },
                        onClick = {
                            outputUnit = "Millimeter"
                            oExpanded = false
                            oConversionFactor.value = 0.001
                            outputName = "Millimeter"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Centimeter") },
                        onClick = {
                            outputUnit = "Centimeter"
                            oExpanded = false
                            oConversionFactor.value = 0.01
                            outputName = "Centimeter"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Inches") },
                        onClick = {
                            outputUnit = "Inches"
                            oExpanded = false
                            oConversionFactor.value = 0.025
                            outputName = "Inches"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Feet") },
                        onClick = {
                            outputUnit = "Feet"
                            oExpanded = false
                            oConversionFactor.value = 0.3048
                            outputName = "Feet"
                            convertUnits()
                        })

                    DropdownMenuItem(text = { Text("Meter") },
                        onClick = {
                            outputUnit = "Meter"
                            oExpanded = false
                            oConversionFactor.value = 1.0
                            outputName = "Meter"
                            convertUnits()
                        })
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Result: ${outputValue}")
    }


}



@Preview(showBackground = true )
@Composable
fun UnitConvertorPreview() {
    UnitConvertor()
}
