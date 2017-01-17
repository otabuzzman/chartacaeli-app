
package chartacaeli;

import java.text.MessageFormat;

public class MessageCatalog extends ApplicationResource {

	private final static String MK_QUALIFIER = "message." ;

	public MessageCatalog( Object clazz ) {
		super( clazz ) ;
	}

	public MessageCatalog( Class<?> clazz ) {
		super( clazz ) ;
	}

	public MessageCatalog() {
		super() ;
	}

	public String message( String key, String def  ) {
		return super.getString( MK_QUALIFIER+key, def ) ;
	}

	public static String message( Object clazz, String key, String def  ) {
		return new MessageCatalog( clazz ).message( key, def ) ;
	}

	public static String message( Class<?> clazz, String key, String def  ) {
		return new MessageCatalog( clazz ).message( key, def ) ;
	}

	public static String compose( Object clazz, String key, Object[] rep ) {
		return compose( key, message( clazz, key, null ), rep ) ;
	}

	public static String compose( Class<?> clazz, String key, Object[] rep ) {
		return compose( key, message( clazz, key, null ), rep ) ;
	}

	private static String compose( String key, String pat, Object[] rep ) {
		StringBuffer msg = new StringBuffer() ;

		if ( pat == null ) {
			if ( rep == null || rep.length == 0 )
				return key ;
			msg.append( key+" :" ) ;
			for ( Object r : rep )
				msg.append( " "+r ) ;
		} else
			msg.append( MessageFormat.format( pat, rep ) ) ;

		return msg.toString() ;
	}
}
