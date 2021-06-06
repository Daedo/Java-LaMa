package org.lama.javaLaMa.org.lama.javaLaMa.matcher;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.lama.javaLaMa.LaMaDSLStandaloneSetupGenerated;
import org.lama.javaLaMa.laMaDSL.Root;

import com.google.inject.Injector;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	Injector injector = new LaMaDSLStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
    	XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
    	
    	URI uri = URI.createFileURI("./src/main/resources/test.lama");
    	Resource resource = resourceSet.getResource(uri, true);

    	Root root = (Root) resource.getContents().get(0);
    	root.getDefinitions().forEach(System.out::println);
    	System.out.println(root);
    }
}
