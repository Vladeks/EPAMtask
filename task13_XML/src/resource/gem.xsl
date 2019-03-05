<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <style>
                    #customers {
                    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                    border-collapse: collapse;
                    width: 100%;
                    }

                    #customers td, #customers th {
                    border: 1px solid #ddd;
                    padding: 8px;
                    }

                    #customers tr:nth-child(even){background-color: #f2f2f2;}

                    #customers tr:hover {background-color: #ddd;}

                    #customers th {
                    padding-top: 12px;
                    padding-bottom: 12px;
                    text-align: left;
                    background-color: #4CAF50;
                    color: white;
                    }
                </style>
            </head>
            <body>
                <h2>Gems</h2>
                <table id="customers">
                    <tr>
                        <th style="text-align:left">Name</th>
                        <th style="text-align:left">Preciousness</th>
                        <th style="text-align:left">Origin</th>
                        <th style="text-align:left">Visual Parameters</th>
                        <th style="text-align:left">Value</th>
                    </tr>
                    <xsl:for-each select="gems/gem">
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="preciousness"/></td>
                            <td><xsl:value-of select="origin"/></td>
                            <td>
                                <table width="100%">
                                    <tr>
                                        <th style="text-align:left">Color</th>
                                        <th style="text-align:left">Transparency</th>
                                        <th style="text-align:left">Diamond Cut</th>
                                    </tr>
                                    <xsl:for-each select="visualParameters">
                                        <tr>
                                            <td><xsl:value-of select="color"/></td>
                                            <td><xsl:value-of select="transparency"/></td>
                                            <td><xsl:value-of select="diamondCut"/></td>
                                        </tr>
                                    </xsl:for-each>
                                </table>
                            </td>
                            <td><xsl:value-of select="value"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>

