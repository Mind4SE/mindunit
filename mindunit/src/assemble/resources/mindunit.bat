@REM  This file is part of "Mind Compiler" is free software: you can redistribute 
@REM  it and/or modify it under the terms of the GNU Lesser General Public License 
@REM  as published by the Free Software Foundation, either version 3 of the 
@REM  License, or (at your option) any later version.
@REM 
@REM  This program is distributed in the hope that it will be useful, but WITHOUT 
@REM  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
@REM  FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more
@REM  details.
@REM 
@REM  You should have received a copy of the GNU Lesser General Public License
@REM  along with this program.  If not, see <http://www.gnu.org/licenses/>.
@REM 
@REM  Contact: mind@ow2.org
@REM 
@REM  Authors: Stephane Seyvoz (sseyvoz@assystem.com)
@REM  Contributors: 
@REM -----------------------------------------------------------------------------
@REM Mind Unit batch script ${project.version}
@REM
@REM Required ENV vars:
@REM ------------------
@REM   JAVA_HOME - location of a JDK home dir
@REM
@REM Optional ENV vars
@REM -----------------
@REM   MINDUNIT_HOME - location of mind unit's installed home dir
@REM   MINDUNIT_OPTS - parameters passed to the Java VM running the mind unit tool
@REM     e.g. to specify logging levels, use
@REM       set MINDUNIT_OPTS=-Ddefault.console.level=FINE -Ddefault.file.level=FINER
@REM   See documentation for more detail on logging system.

@echo off

@REM ==== CHECK JAVA_HOME ===
if not "%JAVA_HOME%" == "" goto OkJHome
echo.
echo ERROR: JAVA_HOME not found in your environment.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation
echo.
goto error

:OkJHome
@REM ==== CHECK JAVA_HOME_EXE ===
if exist "%JAVA_HOME%\bin\java.exe" goto OkJHomeExe

echo.
echo ERROR: JAVA_HOME is set to an invalid directory.
echo JAVA_HOME = "%JAVA_HOME%"
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation
echo.
goto error

:OkJHomeExe
@REM ==== CHECK MINDUNIT_HOME ===
@REM use the batch path to determine MINDUNIT_HOME if not defined.
pushd %~dp0..\
set MINDUNIT_ROOT=%cd%
popd

if "%MINDUNIT_HOME%" == "" set MINDUNIT_HOME=%MINDUNIT_ROOT%

@REM MINDUNIT_HOME defined and different from batch path, use it but warn the user
if /i "%MINDUNIT_HOME%" == "%MINDUNIT_ROOT%" goto endInit
echo.
echo WARNING: Using environment variable MINDUNIT_HOME which is different from mindunit.bat location
echo MINDUNIT_HOME          = %MINDUNIT_HOME% 
echo mindunit.bat location  = %MINDUNIT_ROOT%
echo.

:endInit

setlocal
set MINDUNIT_CMD_LINE_ARGS=%*
set MINDUNIT_RUNTIME=%MINDUNIT_HOME%/runtime
set MINDUNIT_LIB=%MINDUNIT_HOME%/lib
set MINDUNIT_EXT=%MINDUNIT_HOME%/ext
set LAUNCHER=org.ow2.mind.unit.Launcher
set MINDUNIT_JAVA_EXE="%JAVA_HOME%\bin\java.exe"
if not "%MINDUNIT_CLASSPATH%" == "" set MINDUNIT_CLASSPATH=%MINDUNIT_CLASSPATH%;

for /r "%MINDUNIT_LIB%\" %%i in (*.jar) do (
    set VarTmp=%%~fnxi;& call :concat
    )
for /r "%MINDUNIT_EXT%\" %%i in (*.jar) do (
    set VarTmp=%%~fnxi;& call :concat
    )

goto :runMindUnit
:concat
set MINDUNIT_CLASSPATH=%MINDUNIT_CLASSPATH%%VarTmp%
goto :eof

:runMindUnit
%MINDUNIT_JAVA_EXE% -classpath %MINDUNIT_CLASSPATH% %MINDUNIT_OPTS% -Dmindunit.launcher.name=mindunit %LAUNCHER% -src-path=%MINDUNIT_RUNTIME% %MINDUNIT_CMD_LINE_ARGS%


:error
@echo off
if "%OS%"=="Windows_NT" @endlocal
if "%OS%"=="WINNT" @endlocal
(set ERROR_CODE=1)
