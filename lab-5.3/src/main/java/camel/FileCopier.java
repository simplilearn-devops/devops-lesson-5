package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class FileCopier extends RouteBuilder {
	private final Logger logger ;
	private final CamelContext context ;
	
	public FileCopier() {
		logger = LoggerFactory.getLogger( getClass() ) ;
		context = new DefaultCamelContext() ;
		try {
			context.addRoutes( this ) ;
		} catch ( Exception e ) {
			logger.error( "Exception adding route", e ) ;
		}
	}

	@Override
	public void configure() throws Exception {
		logger.info( "Configuring Camel" ) ;
		from( "file:data/input" )
		.to( "file:data/output" ) ;
	}
	
	public void execute() {
		logger.info( "Executing Camel" ) ;
		try {
			context.start() ;
			Thread.sleep( 300000 ) ;
			context.stop() ;
		} catch (Exception e) {
			logger.error( "Exception on execute", e ) ;
		}
	}

	public static void main(String[] args) {
		new FileCopier().execute() ;
	}
}
