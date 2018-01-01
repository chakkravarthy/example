package com.simple;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MergeFiles {

	public String combine(String pathOfFile1, String pathOfFile2) {

		String path = null;

		try {

			// Reading and parsing the Department Name & ID File
			File f = new File(pathOfFile2);

			Reader reader = new FileReader(f);

			BufferedReader br = new BufferedReader(reader);

			Map<String, String> depIDNameMap = new HashMap<String, String>();

			while (br.readLine() != null) {
				String line = br.readLine();
				depIDNameMap.put(line.split(",")[0], line.split(",")[1]);
			}

			// Reading and parsing the Employee Data file,
			// Sample file format : 123(Employee ID), Matt(Employee Name),
			// 5(Dept ID)
			File f1 = new File(pathOfFile2);

			FileReader reader1 = new FileReader(f);

			BufferedReader br1 = new BufferedReader(reader1);

			path = "anypath";

			File mergedFile = new File(path);

			FileWriter writer = new FileWriter(mergedFile);

			BufferedWriter bw = new BufferedWriter(writer);

			while (br1.readLine() != null) {

				StringBuilder sb = new StringBuilder();

				String employeeDataString = br1.readLine();

				String[] empDataArr = employeeDataString.split(",");

				String empID = empDataArr[0];
				String empName = empDataArr[1];
				String depID = empDataArr[2];

				sb.append(empID);
				sb.append(",");
				sb.append(empName);
				sb.append(",");
				sb.append(depIDNameMap.get(depID));

				bw.write(sb.toString());
			}

		} catch (IOException exp) {
			// TODO
		} finally {
			// All the Streams should be closed
		}

		return path;

	}

}