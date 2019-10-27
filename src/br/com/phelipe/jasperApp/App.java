package br.com.phelipe.jasperApp;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

import br.com.phelipe.model.ModelSampleDataVO;
import br.com.phelipe.model.ModelSubRelatorioData;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class App {

	DefaultTableModel tableModel;
	private static JasperPrint jasperPrint;

	public static void main(String[] args) {

		try {
			new App().gerarRelatorio();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void gerarRelatorio() throws JRException, IOException {

		String compileReportToFile = JasperCompileManager.compileReportToFile("report/relatorioPhelipe.jrxml");
		//jasperPrint = JasperFillManager.fillReport(compileReportToFile, tableModelData(), new JRBeanCollectionDataSource(dataSourceList()));
		jasperPrint = JasperFillManager.fillReport(compileReportToFile, tableModelData());
		JasperViewer jasperViewer = new JasperViewer(jasperPrint);
		jasperViewer.setVisible(true);

	}

	private List<ModelSampleDataVO> dataSourceList() {
		List<ModelSubRelatorioData> list = new ArrayList<ModelSubRelatorioData>();
		list.add(new ModelSubRelatorioData("047.107.171-71", "24"));
		ModelSampleDataVO obj1 = new ModelSampleDataVO("Phelipe1", "VALOR 1", list);
		ModelSampleDataVO obj2 = new ModelSampleDataVO("Phelipe2", "VALOR 2", list);
		ModelSampleDataVO obj3 = new ModelSampleDataVO("Phelipe3", "VALOR 3", list);
		List<ModelSampleDataVO> objectList = new ArrayList<ModelSampleDataVO>();
		objectList.add(obj1);
		objectList.add(obj2);
		objectList.add(obj3);
		return objectList;
	}

	private Map<String, Object> tableModelData() throws IOException {
		File pathToFile = new File("images/sicoob.jpg");
		Image image = ImageIO.read(pathToFile);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<ModelSubRelatorioData> list = new ArrayList<ModelSubRelatorioData>();
		list.add(new ModelSubRelatorioData("047.107.171-71", "24"));
		ModelSampleDataVO obj1 = new ModelSampleDataVO("Phelipe1", "VALOR 1", list);
		map.put("modelSampleDataVO", obj1);
		 
		map.put("parametroMeuCampo", "Relatório GESIN-I");
		map.put("logo_sicoob", image);
		map.put("codigoInst", "0001");
		map.put("silgaInst", "SCCS");
		map.put("nomeUsuario", "Phelipe");
		map.put("subReportPhelipe", "report/subRelatorioPhelipe.jasper");
		return map;
	}

}
