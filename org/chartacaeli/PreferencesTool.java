
package org.chartacaeli;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

import org.apache.commons.lang.StringUtils;

public class PreferencesTool
{

	final static int CMD_NONE	= 0 ;
	final static int CMD_BACKUP	= 1 ;
	final static int CMD_DELETE	= 2 ;
	final static int CMD_UPDATE	= 3 ;

	public static void main
	( String[] argv )
	{
		String subarg, file ;
		Preferences root ;
		int cmd ;
		OutputStream backup ;
		InputStream update ;

		root = Preferences.userRoot() ;
		file = StringUtils.EMPTY ;
		cmd = CMD_BACKUP ;

		for ( int i=0 ; argv.length>i ; i++ )
		{
			if ( argv[i].startsWith( "tree=" ) )
			{
				subarg = argv[i].substring( 5 ) ;
				if ( subarg.equals( "system" ) )
				{
					root = Preferences.systemRoot() ;
				}
				else if ( subarg.equals( "user" ) )
				{
					root = Preferences.userRoot() ;
				}
				else
					usage( String.format ( "%s invalid", argv[i]) ) ;
			}
			else if ( argv[i].startsWith( "command=") )
			{
				subarg = argv[i].substring( 8 ) ;
				if ( subarg.equals( "backup" ) )
				{
					cmd = CMD_BACKUP ;
				}
				else if ( subarg.equals( "delete" ) )
				{
					cmd = CMD_DELETE ;
				}
				else if ( subarg.equals( "update" ) )
				{
					cmd = CMD_UPDATE ;
				}
				else
					usage( String.format ( "%s invalid", argv[i]) ) ;
			}
			else
			{
				file = argv[i] ;
			}
		}

		try
		{
			switch ( cmd )
			{
			case CMD_BACKUP:
				if ( file.length()>0 )
				{
					backup = new FileOutputStream( file ) ;
					root.exportSubtree( backup ) ;
				}
				else
					root.exportSubtree( System.out ) ;

				break ;
			case CMD_DELETE:
				Preferences node ;

				for ( String name : root.childrenNames() )
				{
					node = root.node( name ) ;
					node.removeNode() ;
				}

				break ;
			case CMD_UPDATE:
				if ( file.length()>0 )
				{
					update = new FileInputStream( file ) ;
					Preferences.importPreferences( update ) ;
				}
				else
					Preferences.importPreferences( System.in ) ;

				break ;
			case CMD_NONE:
			default:
				usage( "command missing" ) ;

				break ;
			}
		} catch ( IOException
				| BackingStoreException
				| InvalidPreferencesFormatException e )
		{
			e.printStackTrace() ;
			System.exit( 1 ) ;
		}
	}

	private static void usage
	( String msg )
	{
		System.err.printf( "PreferencesTool: %s\n", msg ) ;
		System.err.printf( "java org.chartacaeli.PreferencesTool tree=system|user command=backup|delete|update [<file>]\n" ) ;
		System.exit( 1 ) ;
	}
}
