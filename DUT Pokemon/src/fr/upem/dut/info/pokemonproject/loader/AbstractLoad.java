package fr.upem.dut.info.pokemonproject.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class AbstractLoad {
	
	private static final String fileName = "src/fr/upem/dut/info/pokemonproject/source/";
	private final int version;
	public AbstractLoad () throws IOException {
		this.version=0;
	}
	
	public void create(String fileName) throws IOException{
		Path file = Paths.get(fileName);
		Charset charset = StandardCharsets.UTF_8;
	
		int i = 0;
		try (BufferedReader reader = Files.newBufferedReader(file, charset)){
			String line1;
			while ((line1 = reader.readLine()) != null) {
				String[] line = line1.split(",");
				if(i !=0) {
					add(line);
				}
				i++;
			}
		}
	
	}
	public void add(String[] line) {
		
	}
	

	
}
