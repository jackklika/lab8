package llm.lab7.server;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.internal.$Gson$Types;
import java.lang.reflect.Type;

import llm.lab7.Directory;
import llm.lab7.Employee;

public class MainDirectory implements Directory {
	private ArrayList<Employee> list = new ArrayList<Employee>();

	public void add(Collection<Employee> e) {
		this.list.addAll(e);
	}

	public void print() {
		if (list.isEmpty()) {
			System.out.println("<empty directory>");
		} else {
			for (Employee e : list) {
				System.out.printf("%s, %s %s %s\n", e.lastName, e.firstName, e.department, e.phone);
			}
		}
	}

	public void clear() {
		list.clear();
	}

	@SuppressWarnings("unchecked")
	public void receive(String json) {
		Gson gson = new Gson();
		Type collectionType = new TypeToken<Collection<Employee>>() {
		}.getType();
		this.add((Collection<Employee>) gson.fromJson(json, collectionType));

		// Not sure if this (and the sort method in general goes here or
		// if the list is sorted before it is given to us.
		sort();
	}

	// See employee class for comparator
	public void sort() {
		Collections.sort(list, Employee.NameComparator);

	}

}
