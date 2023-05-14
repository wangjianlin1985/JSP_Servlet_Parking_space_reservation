?/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2008 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 *
 * This file define the HTML entities handled by the editor.
 */

var FCKXHtmlEntities = new Object() ;

FCKXHtmlEntities.Initialize = function()
{
	if ( FCKXHtmlEntities.Entities )
		return ;

	var sChars = '' ;
	var oEntities, e ;

	if ( FCKConfig.ProcessHTMLEntities )
	{
		FCKXHtmlEntities.Entities = {
			// Latin-1 Entities
			'?':'nbsp',
			'?':'iexcl',
			'?':'cent',
			'?':'pound',
			'¡è':'curren',
			'?':'yen',
			'?':'brvbar',
			'¡ì':'sect',
			'¡§':'uml',
			'?':'copy',
			'?':'ordf',
			'?':'laquo',
			'?':'not',
			'?':'shy',
			'?':'reg',
			'?':'macr',
			'¡ã':'deg',
			'¡À':'plusmn',
			'?':'sup2',
			'?':'sup3',
			'?':'acute',
			'?':'micro',
			'?':'para',
			'¡¤':'middot',
			'?':'cedil',
			'?':'sup1',
			'?':'ordm',
			'?':'raquo',
			'?':'frac14',
			'?':'frac12',
			'?':'frac34',
			'?':'iquest',
			'¡Á':'times',
			'¡Â':'divide',

			// Symbols

			'?':'fnof',
			'?':'bull',
			'¡­':'hellip',
			'¡ä':'prime',
			'¡å':'Prime',
			'?':'oline',
			'?':'frasl',
			'?':'weierp',
			'?':'image',
			'?':'real',
			'?':'trade',
			'?':'alefsym',
			'¡û':'larr',
			'¡ü':'uarr',
			'¡ú':'rarr',
			'¡ý':'darr',
			'?':'harr',
			'?':'crarr',
			'?':'lArr',
			'?':'uArr',
			'?':'rArr',
			'?':'dArr',
			'?':'hArr',
			'?':'forall',
			'?':'part',
			'?':'exist',
			'?':'empty',
			'?':'nabla',
			'¡Ê':'isin',
			'?':'notin',
			'?':'ni',
			'¡Ç':'prod',
			'¡Æ':'sum',
			'?':'minus',
			'?':'lowast',
			'¡Ì':'radic',
			'¡Ø':'prop',
			'¡Þ':'infin',
			'¡Ï':'ang',
			'¡Ä':'and',
			'¡Å':'or',
			'¡É':'cap',
			'¡È':'cup',
			'¡Ò':'int',
			'¡à':'there4',
			'?':'sim',
			'?':'cong',
			'¡Ö':'asymp',
			'¡Ù':'ne',
			'¡Ô':'equiv',
			'¡Ü':'le',
			'¡Ý':'ge',
			'?':'sub',
			'?':'sup',
			'?':'nsub',
			'?':'sube',
			'?':'supe',
			'?':'oplus',
			'?':'otimes',
			'¡Í':'perp',
			'?':'sdot',
			'\u2308':'lceil',
			'\u2309':'rceil',
			'\u230a':'lfloor',
			'\u230b':'rfloor',
			'\u2329':'lang',
			'\u232a':'rang',
			'?':'loz',
			'?':'spades',
			'?':'clubs',
			'?':'hearts',
			'?':'diams',

			// Other Special Characters

			'"':'quot',
		//	'&':'amp',		// This entity is automatically handled by the XHTML parser.
		//	'<':'lt',		// This entity is automatically handled by the XHTML parser.
		//	'>':'gt',		// This entity is automatically handled by the XHTML parser.
			'?':'circ',
			'?':'tilde',
			'?':'ensp',
			'?':'emsp',
			'?':'thinsp',
			'?':'zwnj',
			'?':'zwj',
			'?':'lrm',
			'?':'rlm',
			'¨C':'ndash',
			'¡ª':'mdash',
			'¡®':'lsquo',
			'¡¯':'rsquo',
			'?':'sbquo',
			'¡°':'ldquo',
			'¡±':'rdquo',
			'?':'bdquo',
			'?':'dagger',
			'?':'Dagger',
			'¡ë':'permil',
			'?':'lsaquo',
			'?':'rsaquo',
			'¢ã':'euro'
		} ;

		// Process Base Entities.
		for ( e in FCKXHtmlEntities.Entities )
			sChars += e ;

		// Include Latin Letters Entities.
		if ( FCKConfig.IncludeLatinEntities )
		{
			oEntities = {
				'?':'Agrave',
				'?':'Aacute',
				'?':'Acirc',
				'?':'Atilde',
				'?':'Auml',
				'?':'Aring',
				'?':'AElig',
				'?':'Ccedil',
				'?':'Egrave',
				'?':'Eacute',
				'?':'Ecirc',
				'?':'Euml',
				'?':'Igrave',
				'?':'Iacute',
				'?':'Icirc',
				'?':'Iuml',
				'?':'ETH',
				'?':'Ntilde',
				'?':'Ograve',
				'?':'Oacute',
				'?':'Ocirc',
				'?':'Otilde',
				'?':'Ouml',
				'?':'Oslash',
				'?':'Ugrave',
				'?':'Uacute',
				'?':'Ucirc',
				'?':'Uuml',
				'?':'Yacute',
				'?':'THORN',
				'?':'szlig',
				'¨¤':'agrave',
				'¨¢':'aacute',
				'?':'acirc',
				'?':'atilde',
				'?':'auml',
				'?':'aring',
				'?':'aelig',
				'?':'ccedil',
				'¨¨':'egrave',
				'¨¦':'eacute',
				'¨º':'ecirc',
				'?':'euml',
				'¨¬':'igrave',
				'¨ª':'iacute',
				'?':'icirc',
				'?':'iuml',
				'?':'eth',
				'?':'ntilde',
				'¨°':'ograve',
				'¨®':'oacute',
				'?':'ocirc',
				'?':'otilde',
				'?':'ouml',
				'?':'oslash',
				'¨´':'ugrave',
				'¨²':'uacute',
				'?':'ucirc',
				'¨¹':'uuml',
				'?':'yacute',
				'?':'thorn',
				'?':'yuml',
				'?':'OElig',
				'?':'oelig',
				'?':'Scaron',
				'?':'scaron',
				'?':'Yuml'
			} ;

			for ( e in oEntities )
			{
				FCKXHtmlEntities.Entities[ e ] = oEntities[ e ] ;
				sChars += e ;
			}

			oEntities = null ;
		}

		// Include Greek Letters Entities.
		if ( FCKConfig.IncludeGreekEntities )
		{
			oEntities = {
				'¦¡':'Alpha',
				'¦¢':'Beta',
				'¦£':'Gamma',
				'¦¤':'Delta',
				'¦¥':'Epsilon',
				'¦¦':'Zeta',
				'¦§':'Eta',
				'¦¨':'Theta',
				'¦©':'Iota',
				'¦ª':'Kappa',
				'¦«':'Lambda',
				'¦¬':'Mu',
				'¦­':'Nu',
				'¦®':'Xi',
				'¦¯':'Omicron',
				'¦°':'Pi',
				'¦±':'Rho',
				'¦²':'Sigma',
				'¦³':'Tau',
				'¦´':'Upsilon',
				'¦µ':'Phi',
				'¦¶':'Chi',
				'¦·':'Psi',
				'¦¸':'Omega',
				'¦Á':'alpha',
				'¦Â':'beta',
				'¦Ã':'gamma',
				'¦Ä':'delta',
				'¦Å':'epsilon',
				'¦Æ':'zeta',
				'¦Ç':'eta',
				'¦È':'theta',
				'¦É':'iota',
				'¦Ê':'kappa',
				'¦Ë':'lambda',
				'¦Ì':'mu',
				'¦Í':'nu',
				'¦Î':'xi',
				'¦Ï':'omicron',
				'¦Ð':'pi',
				'¦Ñ':'rho',
				'?':'sigmaf',
				'¦Ò':'sigma',
				'¦Ó':'tau',
				'¦Ô':'upsilon',
				'¦Õ':'phi',
				'¦Ö':'chi',
				'¦×':'psi',
				'¦Ø':'omega',
				'\u03d1':'thetasym',
				'\u03d2':'upsih',
				'\u03d6':'piv'
			} ;

			for ( e in oEntities )
			{
				FCKXHtmlEntities.Entities[ e ] = oEntities[ e ] ;
				sChars += e ;
			}

			oEntities = null ;
		}
	}
	else
	{
		FCKXHtmlEntities.Entities = {} ;

		// Even if we are not processing the entities, we must render the &nbsp;
		// correctly. As we don't want HTML entities, let's use its numeric
		// representation (&#160).
		sChars = '?' ;
	}

	// Create the Regex used to find entities in the text.
	var sRegexPattern = '[' + sChars + ']' ;

	if ( FCKConfig.ProcessNumericEntities )
		sRegexPattern = '[^ -~]|' + sRegexPattern ;

	var sAdditional = FCKConfig.AdditionalNumericEntities ;

	if ( sAdditional && sAdditional.length > 0 )
		sRegexPattern += '|' + FCKConfig.AdditionalNumericEntities ;

	FCKXHtmlEntities.EntitiesRegex = new RegExp( sRegexPattern, 'g' ) ;
}
