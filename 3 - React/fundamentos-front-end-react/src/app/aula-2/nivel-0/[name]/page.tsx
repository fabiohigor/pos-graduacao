import Image from "next/image";



//export default function Page() {
//  return <div>Page</div>
//}

import { MeuNome } from "@/components/MeuNome";
import { Hobbies } from "@/components/Hobbies";
import { Imagem } from "@/components/Imagem";
import Link from "next/link";

type PageProps = {
  params: Promise<{
    name: string;
  }>;
}

const Page = async ({ params }: PageProps) => {
  const { name } = await params;
  return (
    <div className="grid gap-y-4"> 
      <MeuNome name={name} age={33} birtDate={new Date(1992, 1, 11)}/>
      <Hobbies />
      <div>
        <p>Gosto de:</p>
        <Imagem />
      </div>
      <Link className="underline" href="/aula-2/nivel-0">Voltar para a página inicial</Link>
    </div>
  );
};

export default Page;