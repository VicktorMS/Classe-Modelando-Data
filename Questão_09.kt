class Data(var dia: Int = 0, var mes: Int = 0, var ano: Int = 0) {
    init {
        require(dia > 0 && mes > 0 && ano > 1899) {
            "A data deve possuir um valor válido (Um dos valores menor que permitido)"
        }
        require(dia < 32 && mes < 13) {
            "A data deve possuir um valor válido (Um dos valores maior que permitido)"
        }
    }

    fun verifAnoBi(): Boolean {
        var anoBi = false
        if (ano % 4 == 0) {
            if (ano % 100 != 0) {
                anoBi = true
            }
        }
        else if (ano % 400 == 0){
            anoBi = true
        }
        return anoBi
    }

    fun qntDiasMes(): Int {
        val mesTrintaUm = listOf(1, 3, 5, 7, 8, 10, 12)
        var mes = 0
        if(mes in mesTrintaUm){
            mes = 31
        }
        else if(mes == 2){
            if (verifAnoBi() == true){
                mes = 29
            }
            else{
                mes = 28
            }
        }
        else{
            mes = 30
        }
        return mes
    }

    fun qntPraData(): Int {
        val mesTrintaUm = listOf(1, 3, 5, 7, 8, 10, 12)
        var qntDias = 0

        for(i in 1..(mes - 1)){
            if(i in mesTrintaUm){
                qntDias += 31
            }
            else if(i == 2){
                if(verifAnoBi() == true){
                    qntDias += 29
                }
                else{
                    qntDias += 28
                }
            }
            else{
                qntDias += 30

            }
        }
        return  qntDias + dia
    }
}
fun main(){

    //datas instaciadas
    var aniversario = Data(26, 4,2004)
    var aniversario2 = Data(26, 11, 2003)

    //A data se encontra em ano bissexto?
    println("Ano Bissexto: ${aniversario.verifAnoBi()}")
    println("Ano Bissexto: ${aniversario2.verifAnoBi()}\n")

    //Quantos dias têm o mês da data?
    println("O mês dessa data possui ${aniversario.qntDiasMes()} dias.")
    println("O mês dessa data possui ${aniversario2.qntDiasMes()} dias.\n")

    //Quantos dias existem entre o dia da data e o primeiro dia do ano inclusive?
    println("Existem ${aniversario.qntPraData()} dias entre o dia da data e o primeiro dia do ano.")
    println("Existem ${aniversario2.qntPraData()} dias entre o dia da data e o primeiro dia do ano.")

}


